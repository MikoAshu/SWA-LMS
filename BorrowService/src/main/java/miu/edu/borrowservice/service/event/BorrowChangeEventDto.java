package miu.edu.borrowservice.service.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import miu.edu.borrowservice.service.BorrowDto;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BorrowChangeEventDto {
    private ChangeEventType event;
    private BorrowDto borrowDto;
}
