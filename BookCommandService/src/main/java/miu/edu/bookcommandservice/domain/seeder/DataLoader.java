package miu.edu.bookcommandservice.domain.seeder;

import miu.edu.bookcommandservice.domain.Book;
import miu.edu.bookcommandservice.repository.BookRepository;
import miu.edu.bookcommandservice.service.BookDto;
import miu.edu.bookcommandservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("DataLoader is running");
        Book book1 = new Book("1234567890", "Java", "Java Book", "Author 1");
        Book book2 = new Book("1234567891", "C#", "C# Book", "Author 2");
        Book book3 = new Book("1234567892", "Python", "Python Book", "Author 3");
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        BookDto bookDto = new BookDto("1234567893", "C++", "C++ Book", "Author 4");
        BookDto bookDto2 = new BookDto("1234567894", "C", "C Book", "Author 5");
        BookDto bookDto3 = new BookDto("1234567895", "Cobol", "Cobol Book", "Author 6");
        bookService.createBook(bookDto);
        bookService.createBook(bookDto2);
        bookService.createBook(bookDto3);

    }
}
