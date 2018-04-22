/*package com.tinygao.kafka.interceptro;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventsConsumerInterceptor implements ConsumerInterceptor<byte[], byte[]>{
        private static final Function<ConsumerRecord<byte[],  byte[]>,
                                     ConsumerRecord<byte[],  byte[]>> changeRecordFormatFunction = (record)->{
            String input = "";
            try {
                input = new String(record.value(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                log.error("Record value change byte[] to String error: ", e);
            }
            ConsumerRecord<byte[],  byte[]> result = new ConsumerRecord<>(
                                                     record.topic(), 
                                                     record.partition(), 
                                                     record.offset(),
                                                     record.timestamp(), 
                                                     record.timestampType(),
                                                     record.checksum(), 
                                                     record.serializedKeySize(),
                                                     record.serializedValueSize(),
                                                     record.key(), 
                                                     getNewFormatRecord(input));
            return result;
        };
        
        private static byte[] getNewFormatRecord(String value) {
            //TODO: Need change value to formal
            String result = value + "test";
            log.debug("Change value: {} to formal value : {}", result);
            try {
                return result.getBytes("utf-8");
            } catch (UnsupportedEncodingException e) {
                log.error("Record value change byte[] to String error: ", e);
            }
            return "".getBytes();
        }

        @Override
        public void configure(Map<String, ?> configs) {
        }

        @Override
        public ConsumerRecords<byte[], byte[]> onConsume(ConsumerRecords<byte[], byte[]> records) {
            Map<TopicPartition, List<ConsumerRecord<byte[], byte[]>>> recordMap = Maps.newHashMap();
            for(TopicPartition tp:records.partitions()) {
                List<ConsumerRecord<byte[], byte[]>> lst = Lists.newArrayList();
                for(ConsumerRecord<byte[], byte[]> record: records.records(tp)) {
                    lst.add(changeRecordFormatFunction.apply(record));
                }
                recordMap.put(tp, lst);
            }
           
            return new ConsumerRecords<byte[], byte[]>(recordMap);
        }

        @Override
        public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {
        }

        @Override
        public void close() {
        }
}*/