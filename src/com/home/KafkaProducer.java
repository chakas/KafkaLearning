package com.home;

import java.util.Properties;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProducer {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", StringSerializer.class.getName());
		props.setProperty("value.serializer", StringSerializer.class.getName());
		props.setProperty("linger.ms", "10000");
		
		Producer<String	, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(props);
		for(int i = 0;i<10;i++) {
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("firsttopic", "test","Message from java # : "+i);
			producer.send(record);
		}
		producer.flush();
		producer.close();
	}
}
