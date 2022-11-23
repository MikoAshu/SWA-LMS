package miu.edu.bookcommandservice.service;

import miu.edu.bookcommandservice.domain.Book;
import miu.edu.bookcommandservice.exception.CustomException;
import miu.edu.bookcommandservice.integration.EventPublisher;
import miu.edu.bookcommandservice.repository.BookRepository;
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
    public void createBook(BookDto bookDto) {
        Book book = BookAdapter.toBook(bookDto);
        bookRepository.save(book);
        BookChangeEventDto bookChangeEventDto = new BookChangeEventDto(BookChangeEventType.CREATE, bookDto);
        eventPublisher.publish(bookChangeEventDto);
    }

    @Override
    public void updateBook(BookDto bookDto) {
        Optional<Book> bookOptional = bookRepository.findById(bookDto.getIsbn());
        if (bookOptional.isPresent()) {
            Book book = BookAdapter.toBook(bookDto);
            bookRepository.save(book);
            BookChangeEventDto bookChangeEventDto = new BookChangeEventDto(BookChangeEventType.UPDATE, bookDto);
            eventPublisher.publish(bookChangeEventDto);
        } else {
            throw new CustomException("Book Not Found", HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    public void deleteBook(String isbn) {
        Optional<Book> book = bookRepository.findById(isbn);
        if (book.isPresent()) {
            bookRepository.delete(book.get());
            BookChangeEventDto bookChangeEventDto = new BookChangeEventDto(BookChangeEventType.DELETE, BookAdapter.toBookDto(book.get()));
            eventPublisher.publish(bookChangeEventDto);
        } else {
            throw new CustomException("Book Not Found", HttpStatus.BAD_REQUEST);
        }
    }
}
