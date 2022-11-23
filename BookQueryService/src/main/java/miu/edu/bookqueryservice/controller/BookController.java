package miu.edu.bookqueryservice.controller;

import miu.edu.bookqueryservice.service.dto.BookDto;
import miu.edu.bookqueryservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBook(isbn));
    }
}
