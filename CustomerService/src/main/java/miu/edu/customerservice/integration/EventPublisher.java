package miu.edu.customerservice.integration;

import miu.edu.customerservice.service.dto.CustomerChangeEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {
    @Autowired
    private KafkaTemplate<String, CustomerChangeEventDto> kafkaTemplate;

    @Value("${app.kafka.topic.customer}")
    private String topic;

    public void publish(CustomerChangeEventDto customerChangeEventDto) {
        System.out.println("Publishing event: " + customerChangeEventDto);
        kafkaTemplate.send(topic, customerChangeEventDto);
    }
}
