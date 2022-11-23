package miu.edu.reviewservice.service;


public interface ReviewService {
    void addReview(ReviewDto reviewDto);
    void updateReview(ReviewDto reviewDto);
    void deleteReview(String isbn);
    ReviewDto getReview(String isbn);
}
