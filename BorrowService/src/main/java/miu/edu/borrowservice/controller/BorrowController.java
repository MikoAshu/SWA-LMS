package miu.edu.borrowservice.controller;

import miu.edu.borrowservice.service.BorrowDto;
import miu.edu.borrowservice.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/borrows")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @GetMapping("/{isbn}")
    public ResponseEntity<BorrowDto> getBorrow(@PathVariable String isbn) {
        return ResponseEntity.ok(borrowService.getBorrow(isbn));
    }

    @PostMapping("/{isbn}/{customerNumber}")
    public ResponseEntity<BorrowDto> addBorrow(@PathVariable String isbn, @PathVariable String customerNumber) {
        borrowService.addBorrow(isbn, customerNumber);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<BorrowDto> updateBorrow(@RequestBody BorrowDto borrowDto) {
        return ResponseEntity.ok(borrowService.updateBorrow(borrowDto));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<BorrowDto> deleteBorrow(@PathVariable String isbn) {
        return ResponseEntity.ok(borrowService.deleteBorrow(isbn));
    }

}
