package miu.edu.reviewservice.service;


import miu.edu.reviewservice.domain.Review;

public class ReviewAdapter {
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
}
