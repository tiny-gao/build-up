package com.tinygao.hadoop;

import com.google.common.base.Splitter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ExtractMovie {
    public static class ExtractMapper
            extends Mapper<Object, Text, Text, Text> {

        private Text word = new Text();
        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException {
            Configuration conf=context.getConfiguration();
            String line = value.toString();

            Splitter splitter = Splitter.on(';');
            if(!line.contains("http://www.movie.com/dor/")) return;
            Iterable<String> it = splitter.split(line);
            StringBuilder sb = new StringBuilder();
            Text outputKey = new Text();
            for(String str:it) {
                if(str.contains("《")) {
                    sb.append(str.substring(str.indexOf("《")+1, str.indexOf("》")));
                    outputKey.set(str.substring(str.indexOf("《")+1, str.indexOf("》")));
                    sb.append(",");
                }
                if(str.matches("\\d{4}.\\d{1,2}.\\d{1,2}")) {
                    sb.append(str);
                    sb.append(",");
                }

                if(str.startsWith("票房（万）")) {
                    sb.append(str.substring(str.indexOf("票房（万）")+5, str.indexOf(" ")));
                }
            }
            word.set(sb.toString());
            context.write(outputKey, word);
        }
    }
    public static class ExtractReduce
            extends Reducer<Text,Text,NullWritable,Text> {
        private Text result = new Text();

        public void reduce(Text key, Iterable<Text> values,
                           Context context
        ) throws IOException, InterruptedException {
            for(Text text:values) {
                result = text;
                break;
            }
            context.write(NullWritable.get(), result);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "extratct");

        job.setJarByClass(ExtractMovie.class);
        job.setMapperClass(ExtractMovie.ExtractMapper.class);
        job.setReducerClass(ExtractMovie.ExtractReduce.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
