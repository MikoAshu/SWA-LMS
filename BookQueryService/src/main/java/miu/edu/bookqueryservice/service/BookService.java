package miu.edu.bookqueryservice.service;


import miu.edu.bookqueryservice.service.dto.BookDto;
import miu.edu.bookqueryservice.service.dto.ReviewDto;

public interface BookService {
    BookDto getBook(String isbn);

    BookDto addBook(BookDto bookDto);

    BookDto updateBook(BookDto bookDto);

    void deleteBook(String isbn);

    void addReview(ReviewDto reviewDto);

    void updateReview(ReviewDto reviewDto);

    void deleteReview(String isbn);

}
