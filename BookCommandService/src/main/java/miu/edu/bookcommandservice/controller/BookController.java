package miu.edu.bookcommandservice.controller;

import miu.edu.bookcommandservice.service.BookDto;
import miu.edu.bookcommandservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("")
    public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("")
    public ResponseEntity<?> updateBook(@RequestBody BookDto bookDto) {
        bookService.updateBook(bookDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
        return ResponseEntity.ok().build();
    }
}
