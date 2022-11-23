package miu.edu.bookqueryservice.service;

import miu.edu.bookqueryservice.domain.Book;
import miu.edu.bookqueryservice.domain.Review;
import miu.edu.bookqueryservice.exception.CustomException;
import miu.edu.bookqueryservice.integration.EventPublisher;
import miu.edu.bookqueryservice.repository.BookRepository;
import miu.edu.bookqueryservice.service.dto.BookChangeEventDto;
import miu.edu.bookqueryservice.service.dto.BookDto;
import miu.edu.bookqueryservice.service.dto.ChangeEventType;
import miu.edu.bookqueryservice.service.dto.ReviewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    BookRepository bookRepository;


    @Override
    public BookDto getBook(String isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        if (book.isPresent()) {
            return BookAdapter.toBookDto(book.get());
        } else {
            throw new CustomException("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book = BookAdapter.toBook(bookDto);
        bookRepository.save(book);
        eventPublisher.publish( new BookChangeEventDto(ChangeEventType.CREATE, BookAdapter.toBookDto(book)));
        return BookAdapter.toBookDto(book);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Optional<Book> book = bookRepository.findById(bookDto.getIsbn());
        if (book.isPresent()) {
            Book book1 = BookAdapter.toBook(bookDto);
            bookRepository.save(book1);
            eventPublisher.publish( new BookChangeEventDto(ChangeEventType.UPDATE, BookAdapter.toBookDto(book1)));
            return BookAdapter.toBookDto(book1);
        } else {
            throw new CustomException("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteBook(String isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            eventPublisher.publish( new BookChangeEventDto(ChangeEventType.DELETE, BookAdapter.toBookDto(book.get())));
        } else {
            throw new CustomException("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void addReview(ReviewDto reviewDto) {
        Optional<Book> book = bookRepository.findById(reviewDto.getIsbn());
        if (book.isPresent()) {
            book.get().getReviews().add(BookAdapter.toReview(reviewDto));
            bookRepository.save(book.get());
            eventPublisher.publish( new BookChangeEventDto(ChangeEventType.UPDATE, BookAdapter.toBookDto(book.get())));
        } else {
            throw new CustomException("Book not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void updateReview(ReviewDto reviewDto) {

    }

    @Override
    public void deleteReview(String isbn) {

    }
}
