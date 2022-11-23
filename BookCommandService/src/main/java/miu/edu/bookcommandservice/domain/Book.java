package miu.edu.bookcommandservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    @Id
    private String isbn;
    private String title;
    private String description;
    private String authorName;
}
