package miu.edu.bookqueryservice.service;

import miu.edu.bookqueryservice.domain.Book;
import miu.edu.bookqueryservice.domain.Review;
import miu.edu.bookqueryservice.service.dto.BookDto;
import miu.edu.bookqueryservice.service.dto.ReviewDto;

import java.util.List;

public class BookAdapter {
    public static ReviewDto toReviewDto(Review review) {
        return new ReviewDto(
                review.getId(),
                review.getIsbn(),
                review.getReviewRating(),
                review.getCustomerName(),
                review.getDescription());
    }

    public static Review toReview(ReviewDto reviewDto) {
        return new Review(
                reviewDto.getId(),
                reviewDto.getIsbn(),
                reviewDto.getReviewRating(),
                reviewDto.getCustomerName(),
                reviewDto.getDescription());
    }

    public static BookDto toBookDto(Book book) {
        List<ReviewDto> reviewDtos = book.getReviews() != null ?
                book.getReviews().stream().map(BookAdapter::toReviewDto).toList() :
                null;
        return new BookDto(
                book.getIsbn(),
                book.getTitle(),
                book.getDescription(),
                book.getAuthorName(),
                reviewDtos);
    }

    public static Book toBook(BookDto bookDto) {
        List<Review> reviews = bookDto.getReviewDto() != null ?
                bookDto.getReviewDto().stream().map(BookAdapter::toReview).toList() :
                null;
        return new Book(
                bookDto.getIsbn(),
                bookDto.getTitle(),
                bookDto.getDescription(),
                bookDto.getAuthorName(),
                reviews);
    }
}
