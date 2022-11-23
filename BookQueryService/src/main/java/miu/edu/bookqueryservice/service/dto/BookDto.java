package miu.edu.bookqueryservice.service.dto;

import lombok.*;
import miu.edu.bookqueryservice.domain.Review;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BookDto {
    private String isbn;
    private String title;
    private String description;
    private String authorName;
    private List<ReviewDto> reviewDto;

    public BookDto(String isbn, String title, String description, String authorName) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.authorName = authorName;
        this.reviewDto = new ArrayList<>();
    }
}