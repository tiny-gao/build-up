package com.tinygao.http.heatbeat;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.client.api.Result;
import org.eclipse.jetty.http.HttpMethod;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeartbeatFailureDetector implements FailureDetector {

    private final static ScheduledExecutorService executor = Executors
            .newSingleThreadScheduledExecutor(daemonThreadsNamed("failure-detector"));
    
    public static ThreadFactory daemonThreadsNamed(String nameFormat)
    {
        return new ThreadFactoryBuilder()
                .setNameFormat(nameFormat)
                .setDaemon(true)
                .build();
    }
    @Override
    public State getState(HostAddress hostAddress) {
        
        return null;
    }
    
    private static void ping() throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.start();
        httpClient.newRequest("http://www.baidu.com")
            .method(HttpMethod.HEAD)
            .timeout(3, TimeUnit.SECONDS)
            .send(new Response.CompleteListener(){
                  public void onComplete(Result result) {
                      log.info("{}-=-=-=-=-=-=-=-=-=-=-=return", Thread.currentThread().getName());
                      log.info("log fail {}", result);
                     }
                 });
        httpClient.stop();
        log.info("ping --------------------===");
    }
    public void shutdown()
    {
        executor.shutdownNow();
    }
    public static void main(String[] args) throws Exception {
        ping();
        executor.scheduleWithFixedDelay(() -> {
            try {
                ping();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },0, 1, TimeUnit.SECONDS);
        
        TimeUnit.SECONDS.sleep(3);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);
    }
}
