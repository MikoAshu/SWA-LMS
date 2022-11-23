package miu.edu.reviewservice.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class ReviewDto {
    private String id;
    private String isbn;
    private int reviewRating;
    private String customerName;
    private String description;

    public ReviewDto(String isbn, int reviewRating, String customerName, String description) {
        this.isbn = isbn;
        this.reviewRating = reviewRating;
        this.customerName = customerName;
        this.description = description;
    }
}
