package miu.edu.bookqueryservice.integration;

import miu.edu.bookqueryservice.service.dto.BookChangeEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {
    @Autowired
    private KafkaTemplate<String, BookChangeEventDto> kafkaTemplate;

    @Value("${app.kafka.topic.bookQuery}")
    private String topic;

    public void publish(BookChangeEventDto bookChangeEventDto) {
        System.out.println("Publishing event: " + bookChangeEventDto);
        kafkaTemplate.send(topic, bookChangeEventDto);
    }
}
