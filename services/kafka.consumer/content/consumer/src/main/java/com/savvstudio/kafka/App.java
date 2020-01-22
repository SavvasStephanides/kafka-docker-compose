package com.savvstudio.kafka;

import java.util.*;
import org.apache.kafka.clients.consumer.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka.queue:9092"); 
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); 
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("group.id", "mygroup");

        KafkaConsumer myConsumer = new KafkaConsumer(props);
        myConsumer.subscribe(Arrays.asList("mytopic"));

        while(true){
            ConsumerRecords<String, String> records = myConsumer.poll(100);

            for (ConsumerRecord<String, String> record : records){
                System.out.println("New message: " + record.value());
            }
                        
        }

        // myConsumer.close();
    }
}
