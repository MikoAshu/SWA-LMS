package miu.edu.client.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BooksDto {
    List<BookDto> bookDtos;
}
