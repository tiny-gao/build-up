package com.tinygao.jmeter;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.util.security.Credential.MD5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tinygao
 * 1、流量控制：线程组-> Constant Throughput Timer 有多种模式，其中this thread only表示一分钟一个线程多少个请求
 * 2、线程组->线程数是jmeter启动的线程数量； Ramp-up Period是多少秒启动所有的线程
 *   加入60 和 60 也就是每一秒启动一个线程
 */
public class HttpJavaSampler extends AbstractJavaSamplerClient{

    private final static AtomicInteger time = new AtomicInteger(0);
    private final static  Stopwatch stopwatch = Stopwatch.createStarted();
    private final static RateLimiter rate = RateLimiter.create(0.2D);
    
    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("appId", "");
        params.addArgument("name", "");
        params.addArgument("url", "");
        return params;
    }
    
    public static ThreadFactory threadsNamed(String nameFormat){
        return new ThreadFactoryBuilder().setNameFormat(nameFormat).setDaemon(true).build();
    }
    private final static ExecutorService es = Executors.newSingleThreadExecutor(threadsNamed("jmeter-data-%d"));
    public void setupTest(JavaSamplerContext context) {
        es.submit(HttpJavaSampler::doLog);
    }
    
    public void teardownTest(JavaSamplerContext context) {
        stopwatch.stop();
        es.shutdown();
    }
    @Override
    public SampleResult runTest(JavaSamplerContext args)  {
       
        SampleResult result = new SampleResult();
        result.sampleStart();
        HttpClient httpClient = new HttpClient();
        try {
            httpRemote(httpClient, args);
        httpClient.stop();
        result.sampleEnd();
        //请求成功，设置测试结果为成功
        result.setSuccessful(true);
        result.setResponseMessage("message..");
        result.setResponseCodeOK();
        time.incrementAndGet();
        } catch (Exception e1) {
            //请求失败，设置测试结果为失败
            result.sampleEnd();
            result.setSuccessful(false);
            result.setResponseCode("500");
        }
        return result;
    }

    private static void doLog() {
        while(!es.isShutdown()) {
            rate.acquire();
            System.out.println(String.format("currentTime: %s, "
                    + "elapsed: %s (ms), requestTime: %s",
                    LocalDateTime.now(), 
                    stopwatch.elapsed(TimeUnit.MILLISECONDS),
                    time.get()));
        }
    }

    private static void httpRemote(HttpClient httpClient, JavaSamplerContext args) throws Exception {
      httpClient.start();
      Map<String, String> req = new TreeMap<String, String>();
      req.put("appId", args.getParameter("appId"));
      req.put("body", args.getParameter("body"));
     //避免测试重复
      String deviceId = ""+System.nanoTime();
      req.put("timestamp", ""+Duration.ofMillis(System.currentTimeMillis()).getSeconds());
      //对应100000168_tab
      req.put("name", args.getParameter("name"));
     StringBuilder sb = new StringBuilder();
      sb.append("appid=").append(req.get("appId"))
        .append("&body=").append(req.get("body"))
        .append("&timestamp=").append(req.get("timestamp"));
      req.put("sign", MD5.digest(sb.toString()).toLowerCase().substring(4));
      
      
      httpClient.newRequest(args.getParameter("url"))
        .content(new StringContentProvider(JSON.toJSONString(req), "utf-8"), "application/json")
        .method(HttpMethod.POST)
        .timeout(300, TimeUnit.SECONDS)
        .send();
      httpClient.stop();
    }
}
