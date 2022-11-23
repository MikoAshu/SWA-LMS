package miu.edu.bookqueryservice.service;

import miu.edu.bookqueryservice.domain.Book;
import miu.edu.bookqueryservice.domain.Review;
import miu.edu.bookqueryservice.service.dto.BookDto;
import miu.edu.bookqueryservice.service.dto.ReviewDto;

public class BookAdapter {
    public static ReviewDto toReviewDto(Review review) {
        return new ReviewDto(
                review.getIsbn(),
                review.getReviewRating(),
                review.getCustomerName(),
                review.getDescription());
    }

    public static Review toReview(ReviewDto reviewDto) {
        return new Review(
                reviewDto.getIsbn(),
                reviewDto.getReviewRating(),
                reviewDto.getCustomerName(),
                reviewDto.getDescription());
    }

    public static BookDto toBookDto(Book book) {
        return new BookDto(
                book.getIsbn(),
                book.getTitle(),
                book.getDescription(),
                book.getAuthorName(),
                toReviewDto(book.getReviews()));
    }

    public static Book toBook(BookDto bookDto) {
        return new Book(
                bookDto.getIsbn(),
                bookDto.getTitle(),
                bookDto.getDescription(),
                bookDto.getAuthorName(),
                toReview(bookDto.getReviewDto()));
    }
}
