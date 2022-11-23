package miu.edu.borrowservice.service;


import miu.edu.borrowservice.domain.Borrow;

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
}
