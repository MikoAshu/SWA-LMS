package miu.edu.client.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {
    private String isbn;
    private String title;
    private String description;
    private String authorName;
}
