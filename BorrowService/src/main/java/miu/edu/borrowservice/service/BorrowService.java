package miu.edu.borrowservice.service;

import java.util.List;

public interface BorrowService {
    List<BorrowDto> getBorrow(String isbn);
    void addBorrow(String isbn, String customerNumber);
    BorrowDto updateBorrow(BorrowDto borrowDto);
    void updateBorrow(BookDto bookDto);
    void updateBorrow(CustomerDto customerDto);
    BorrowDto deleteBorrow(String isbn);
}
