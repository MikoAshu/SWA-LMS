package miu.edu.client.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class BorrowDto {
    private String borrowingNumber;
    private Date date;
    private String customerNumber;
    private String customerName;
    private String isbn;
    private String bookTitle;
}
