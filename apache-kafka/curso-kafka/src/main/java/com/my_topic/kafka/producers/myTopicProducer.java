package com.my_topic.kafka.producers;

import java.util.Properties;
import org.slf4j.Logger;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.LoggerFactory;

public class myTopicProducer {

    public static final Logger log = LoggerFactory.getLogger(myTopicProducer.class);
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

try (Producer<String, String> producer = new KafkaProducer<>(props)) {
    // envío de forma asincróna
    // get: de forma sincróna, pero más tardado
    for (int i = 0; i < 5000; i++) {
        producer.send(new ProducerRecord<>("my-topic", String.valueOf(i), "my-value"))/* .get() */;
    }
    producer.flush();
    System.out.println("Mensaje enviado a Kafka correctamente 🚀");     
    //Thread.sleep(1000); // ✅ este sí lanza InterruptedException
// } catch (InterruptedException e) {
//     log.error("Message producer interrupted", e);
}
 catch (Exception e) {
    log.error("Message producer interrupted", e);
}
    }
}
