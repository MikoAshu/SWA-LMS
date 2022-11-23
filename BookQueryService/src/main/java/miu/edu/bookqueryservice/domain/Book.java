package miu.edu.bookqueryservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    @Id
    private String isbn;
    private String title;
    private String description;
    private String authorName;
    private List<Review> reviews;

}
