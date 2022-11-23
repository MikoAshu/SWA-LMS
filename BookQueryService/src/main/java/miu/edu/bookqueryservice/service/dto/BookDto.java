package miu.edu.bookqueryservice.service.dto;

import lombok.*;

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
}