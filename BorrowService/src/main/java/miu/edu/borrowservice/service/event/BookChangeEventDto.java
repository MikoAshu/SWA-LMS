package miu.edu.borrowservice.service.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import miu.edu.borrowservice.service.BookDto;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BookChangeEventDto {
    private ChangeEventType event;
    private BookDto bookDto;
}
