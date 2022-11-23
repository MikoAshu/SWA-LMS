package miu.edu.bookqueryservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BookChangeEventDto {
    private ChangeEventType event;
    private BookDto bookDto;
}
