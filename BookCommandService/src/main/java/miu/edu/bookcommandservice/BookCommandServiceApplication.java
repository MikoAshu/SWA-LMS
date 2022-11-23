package miu.edu.bookcommandservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BookCommandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookCommandServiceApplication.class, args);
    }

}
