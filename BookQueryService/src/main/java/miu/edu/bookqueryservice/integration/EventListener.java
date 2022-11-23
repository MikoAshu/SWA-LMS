package miu.edu.bookqueryservice.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import miu.edu.bookqueryservice.service.dto.BookChangeEventDto;
import miu.edu.bookqueryservice.service.BookService;
import miu.edu.bookqueryservice.service.dto.ChangeEventType;
import miu.edu.bookqueryservice.service.dto.ReviewChangeEventDto;
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
    BookService bookService;

    @Value("${app.kafka.topic.book}")
    private static String topic;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "BookTopic")
    public void receiveBookEvent(@Payload String bookChangeEventString,
                        @Headers MessageHeaders headers) {

        System.out.println("Received event: " + bookChangeEventString);
        try {
            BookChangeEventDto bookChangeEventDto = objectMapper.readValue(bookChangeEventString, BookChangeEventDto.class);
            if (bookChangeEventDto.getEvent().equals(ChangeEventType.UPDATE)) {
                bookService.updateBook(bookChangeEventDto.getBookDto());
            } else if (bookChangeEventDto.getEvent().equals(ChangeEventType.CREATE)) {
                bookService.addBook(bookChangeEventDto.getBookDto());
            } else if (bookChangeEventDto.getEvent().equals(ChangeEventType.DELETE)) {
                bookService.deleteBook(bookChangeEventDto.getBookDto().getIsbn());
            } else {
                System.out.println("Unknown event type: " + bookChangeEventDto.getEvent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "reviewTopic")
    public void receiveReviewEvent(@Payload String reviewChangeEventString,
                                 @Headers MessageHeaders headers) {

        System.out.println("Received event: " + reviewChangeEventString);
        try {
            ReviewChangeEventDto reviewChangeEventDto = objectMapper.readValue(reviewChangeEventString, ReviewChangeEventDto.class);
            if (reviewChangeEventDto.getEvent().equals(ChangeEventType.UPDATE)) {
                bookService.updateReview(reviewChangeEventDto.getReviewDto());
            } else if (reviewChangeEventDto.getEvent().equals(ChangeEventType.CREATE)) {
                bookService.addReview(reviewChangeEventDto.getReviewDto());
            } else if (reviewChangeEventDto.getEvent().equals(ChangeEventType.DELETE)) {
                bookService.deleteReview(reviewChangeEventDto.getReviewDto().getIsbn(), reviewChangeEventDto.getReviewDto().getId());
            } else {
                System.out.println("Unknown event type: " + reviewChangeEventDto.getEvent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}