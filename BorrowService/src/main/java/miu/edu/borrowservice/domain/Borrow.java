package miu.edu.borrowservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Borrow {
    @Id
    private String borrowingNumber;
    private Date date;
    private String customerNumber;
    private String customerName;
    private String isbn;
    private String bookTitle;
}
