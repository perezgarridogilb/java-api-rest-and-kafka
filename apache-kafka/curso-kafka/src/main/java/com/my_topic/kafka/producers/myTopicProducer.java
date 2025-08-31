package com.my_topic.kafka.producers;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class myTopicProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            // envío de forma asincróna

            producer.send(new ProducerRecord<>("my-topic", "my-key", "my-value"));
            System.out.println("Mensaje enviado a Kafka correctamente 🚀");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
