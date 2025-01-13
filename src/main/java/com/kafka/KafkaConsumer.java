package com.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class KafkaConsumer {

    @KafkaListener(topics = "test-topic", groupId = "ai-row-data")
    public void listen(ConsumerRecord<String, String> record) {
        log.info("[ Kafka Consumer ] 받은 메시지 : {} / Topic : {}", record.value(), record.topic());
    }
}
