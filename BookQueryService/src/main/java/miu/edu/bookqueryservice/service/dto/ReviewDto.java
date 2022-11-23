package miu.edu.bookqueryservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ReviewDto {
    private String id;
    private String isbn;
    private int reviewRating;
    private String customerName;
    private String description;
}
