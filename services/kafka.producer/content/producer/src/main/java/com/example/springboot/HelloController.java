package com.example.springboot;

import java.util.*;
import org.apache.kafka.clients.producer.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class HelloController {

	@PostMapping("/")
	public String postMessage(@RequestBody Message message) {
		String messageBody = message.getBody();

		Properties props = new Properties();
        props.put("bootstrap.servers", "kafka.queue:9092"); 
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); 
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		KafkaProducer<String,String> producer = new KafkaProducer<String,String>(props);
        
        String topic = "mytopic";

		ProducerRecord messageRecord = new ProducerRecord(topic, messageBody);
		producer.send(messageRecord);
        
        producer.close();

		return messageBody;
	}

}
