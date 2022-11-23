package miu.edu.reviewservice.service;

import miu.edu.reviewservice.domain.Review;
import miu.edu.reviewservice.exception.CustomException;
import miu.edu.reviewservice.integration.EventPublisher;
import miu.edu.reviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public void addReview(ReviewDto reviewDto) {
        Review review = ReviewAdapter.toReview(reviewDto);
        reviewRepository.save(review);
        ReviewChangeEventDto reviewChangeEventDto = new ReviewChangeEventDto(ChangeEventType.CREATE, reviewDto);
        eventPublisher.publish(reviewChangeEventDto);

    }

    @Override
    public void updateReview(ReviewDto reviewDto) {
        Optional<Review> reviewOptional = reviewRepository.findById(reviewDto.getIsbn());
        if (reviewOptional.isPresent()) {
            Review review = ReviewAdapter.toReview(reviewDto);
            reviewRepository.save(review);
            ReviewChangeEventDto reviewChangeEventDto = new ReviewChangeEventDto(ChangeEventType.UPDATE, reviewDto);
            eventPublisher.publish(reviewChangeEventDto);
        } else {
            throw new CustomException("Review not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteReview(String isbn) {
        Optional<Review> review = reviewRepository.findById(isbn);
        if (review.isPresent()) {
            reviewRepository.delete(review.get());
            ReviewChangeEventDto reviewChangeEventDto = new ReviewChangeEventDto(ChangeEventType.DELETE, ReviewAdapter.toReviewDto(review.get()));
            eventPublisher.publish(reviewChangeEventDto);
        } else {
            throw new CustomException( "Review not found",HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ReviewDto getReview(String isbn) {
        Optional<Review> review = reviewRepository.findById(isbn);
        if (review.isPresent()) {
            return ReviewAdapter.toReviewDto(review.get());
        } else {
            throw new CustomException( "Review not found",HttpStatus.NOT_FOUND);
        }
    }
}
