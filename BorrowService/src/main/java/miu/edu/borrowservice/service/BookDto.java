package miu.edu.borrowservice.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BookDto {
    private String isbn;
    private String title;
    private String description;
    private String authorName;
}
