package miu.edu.bookcommandservice.service;


public interface BookService {
    void createBook(BookDto bookDto);
    void updateBook(BookDto bookDto);
    void deleteBook(String isbn);
}
