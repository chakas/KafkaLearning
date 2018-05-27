package com.home;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumer {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.deserializer", StringDeserializer.class.getName());
		props.setProperty("value.deserializer", StringDeserializer.class.getName());
		
		props.setProperty("group.id", "test");
		
		
		//Kafka Consumer over her
		org.apache.kafka.clients.consumer.KafkaConsumer<String, String> consumer = new org.apache.kafka.clients.consumer.KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("firsttopic"));
		while(true) {
			ConsumerRecords<String, String> record = consumer.poll(1000);
			for(ConsumerRecord<String,String> rec: record) {
				System.out.println(rec.key());
				System.out.println(rec.value());
			}
		}
		
	}
}
