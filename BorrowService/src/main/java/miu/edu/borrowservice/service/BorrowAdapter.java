package miu.edu.borrowservice.service;


import miu.edu.borrowservice.domain.Borrow;

import java.util.List;

public class BorrowAdapter {

    public static BorrowDto toBorrowDto(Borrow borrow) {
        return new BorrowDto(
                borrow.getBorrowingNumber(),
                borrow.getDate(),
                borrow.getCustomerNumber(),
                borrow.getCustomerName(),
                borrow.getIsbn(),
                borrow.getBookTitle());
    }

    public static Borrow toBorrow(BorrowDto borrowDto) {
        return new Borrow(
                borrowDto.getBorrowingNumber(),
                borrowDto.getDate(),
                borrowDto.getCustomerNumber(),
                borrowDto.getCustomerName(),
                borrowDto.getIsbn(),
                borrowDto.getBookTitle());
    }

    public static List<BorrowDto> toBorrowDtoList(List<Borrow> borrows) {
        return borrows.stream().map(BorrowAdapter::toBorrowDto).toList();
    }
}
