package miu.edu.reviewservice.controller;

import miu.edu.reviewservice.service.ReviewDto;
import miu.edu.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping()
    public ResponseEntity<?> addReview(@RequestBody ReviewDto reviewDto) {
        reviewService.addReview(reviewDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<?> updateReview(@RequestBody ReviewDto reviewDto) {
        reviewService.updateReview(reviewDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<?> deleteReview(@PathVariable String isbn) {
        reviewService.deleteReview(isbn);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<?> getReview(@PathVariable String isbn) {
        return ResponseEntity.ok(reviewService.getReview(isbn));
    }
}
