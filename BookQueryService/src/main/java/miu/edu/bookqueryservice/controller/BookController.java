package miu.edu.bookqueryservice.controller;

import miu.edu.bookqueryservice.service.dto.BookDto;
import miu.edu.bookqueryservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable String isbn) {
        return ResponseEntity.ok(bookService.getBook(isbn));
    }

    @GetMapping("")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
