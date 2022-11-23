package miu.edu.reviewservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Review {
    @Id
    private String isbn;
    private int reviewRating;
    private String customerName;
    private String description;

    public Review() {
    }

    public Review(String isbn, int reviewRating, String customerName, String description) {
        this.isbn = isbn;
        this.reviewRating = reviewRating;
        this.customerName = customerName;
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Review{" +
                "isbn='" + isbn + '\'' +
                ", reviewRating=" + reviewRating +
                ", customerName='" + customerName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
