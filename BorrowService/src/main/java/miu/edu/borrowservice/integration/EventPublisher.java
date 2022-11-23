package miu.edu.borrowservice.integration;

import miu.edu.borrowservice.service.event.BorrowChangeEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {
    @Autowired
    private KafkaTemplate<String, BorrowChangeEventDto> kafkaTemplate;

    @Value("${app.kafka.topic.review}")
    private String topic;

    public void publish(BorrowChangeEventDto borrowChangeEventDto) {
        System.out.println("Publishing event: " + borrowChangeEventDto);
        kafkaTemplate.send(topic, borrowChangeEventDto);
    }
}
