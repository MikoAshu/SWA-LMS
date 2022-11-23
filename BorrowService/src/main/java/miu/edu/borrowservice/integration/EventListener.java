package miu.edu.borrowservice.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import miu.edu.borrowservice.service.BorrowService;
import miu.edu.borrowservice.service.event.BookChangeEventDto;
import miu.edu.borrowservice.service.event.ChangeEventType;
import miu.edu.borrowservice.service.event.CustomerChangeEventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EventListener {
    @Autowired
    BorrowService burrowService;

    @Value("${app.kafka.topic.book}")
    private static String topic;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "BookTopic")
    public void receiveBook(@Payload String bookChangeEventString,
                        @Headers MessageHeaders headers) {

        System.out.println("Received book event: " + bookChangeEventString);
        try {
            BookChangeEventDto bookChangeEventDto = objectMapper.readValue(bookChangeEventString, BookChangeEventDto.class);
            if (bookChangeEventDto.getEvent().equals(ChangeEventType.UPDATE)) {
                burrowService.updateBorrow(bookChangeEventDto.getBookDto());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "CustomerTopic")
    public void receiveCustomer(@Payload String customerChangeEventString,
                        @Headers MessageHeaders headers) {
        System.out.println("Received customer event: " + customerChangeEventString);
        try {
            CustomerChangeEventDto customerChangeEventDto = objectMapper.readValue(customerChangeEventString, CustomerChangeEventDto.class);
            if (customerChangeEventDto.getEvent().equals(ChangeEventType.UPDATE)) {
                burrowService.updateBorrow(customerChangeEventDto.getCustomerDto());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}