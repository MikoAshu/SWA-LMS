package miu.edu.reviewservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Document
public class Review {
    @Id
    private String id;
    private String isbn;
    private int reviewRating;
    private String customerName;
    private String description;

    public Review(String isbn, int reviewRating, String customerName, String description) {
        this.isbn = isbn;
        this.reviewRating = reviewRating;
        this.customerName = customerName;
        this.description = description;
    }
}
