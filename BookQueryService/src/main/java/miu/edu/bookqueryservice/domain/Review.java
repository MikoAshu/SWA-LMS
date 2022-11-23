package miu.edu.bookqueryservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Review {
    private String isbn;
    private int reviewRating;
    private String customerName;
    private String description;
}
