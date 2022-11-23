package miu.edu.bookcommandservice.service;

import miu.edu.bookcommandservice.domain.Book;

public class BookAdapter {
    public static BookDto toBookDto(Book book) {
        return new BookDto(
                book.getIsbn(),
                book.getTitle(),
                book.getDescription(),
                book.getAuthorName());
    }

    public static Book toBook(BookDto bookDto) {
        return new Book(
                bookDto.getIsbn(),
                bookDto.getTitle(),
                bookDto.getDescription(),
                bookDto.getAuthorName());
    }
}
