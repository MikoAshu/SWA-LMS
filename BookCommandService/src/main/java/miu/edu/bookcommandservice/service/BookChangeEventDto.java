package miu.edu.bookcommandservice.service;

import lombok.*;

enum BookChangeEventType {
    CREATE, UPDATE, DELETE
}
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class BookChangeEventDto {
    private BookChangeEventType event;
    private BookDto bookDto;
}
