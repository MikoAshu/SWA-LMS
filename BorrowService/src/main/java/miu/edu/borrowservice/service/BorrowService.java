package miu.edu.borrowservice.service;

public interface BorrowService {
    BorrowDto getBorrow(String isbn);
    void addBorrow(String isbn, String customerNumber);
    BorrowDto updateBorrow(BorrowDto borrowDto);
    void updateBorrow(BookDto bookDto);
    void updateBorrow(CustomerDto customerDto);
    BorrowDto deleteBorrow(String isbn);
}
