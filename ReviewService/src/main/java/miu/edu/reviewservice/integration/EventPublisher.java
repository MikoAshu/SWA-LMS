package miu.edu.reviewservice.integration;

import miu.edu.reviewservice.service.ReviewChangeEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {
    @Autowired
    private KafkaTemplate<String, ReviewChangeEventDto> kafkaTemplate;

    @Value("${app.kafka.topic.review}")
    private String topic;

    public void publish(ReviewChangeEventDto reviewChangeEventDto) {
        System.out.println("Publishing event: " + reviewChangeEventDto);
        kafkaTemplate.send(topic, reviewChangeEventDto);
    }
}
