package miu.edu.bookqueryservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
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

    public Book(String isbn, String title, String description, String authorName) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.authorName = authorName;
        this.reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
}
