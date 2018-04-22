package com.tinygao.kafka.client;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KafkaProducerClient {
        
    private final static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();   
        props.put("bootstrap.servers", "192.168.8.215:9092");   
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("request.required.acks","1");   
        Producer<String, String> producer = new KafkaProducer<>(props);
        while (true && count.get()< 60) {
            ProducerRecord<String, String> records = new ProducerRecord<String, String>("test", ""+System.currentTimeMillis()%2);
            
            producer.send(records, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if(exception != null) {
                            log.error("Error for producer {}", exception);
                        }
                        count.incrementAndGet();
                }
            });
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        producer.close();
        log.info("producer msgs num : {}", count.get());
    }   
}
