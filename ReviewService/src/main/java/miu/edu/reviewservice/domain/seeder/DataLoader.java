package miu.edu.reviewservice.domain.seeder;

import miu.edu.reviewservice.domain.Review;
import miu.edu.reviewservice.repository.ReviewRepository;
import miu.edu.reviewservice.service.ReviewDto;
import miu.edu.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ReviewService reviewService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("DataLoader: Loading data");
        reviewRepository.deleteAll();
//        Review review1 = new Review("1234567890",5,  "Daniel Adam", "Great book");
//        Review review2 = new Review("1234567891",4,  "Rose Ken", "Good book");
//        Review review3 = new Review("1234567892",3,  "Mil Shadow", "Average book");

        ReviewDto reviewDto1 = new ReviewDto( "1234567890",5,  "Daniel Adam", "Great book");
        ReviewDto reviewDto2 = new ReviewDto( "1234567891",4,  "Rose Ken", "Good book");

//        reviewService.addReview(reviewDto1);
//        reviewService.addReview(reviewDto2);

//        reviewRepository.save(review1);
//        reviewRepository.save(review2);
//        reviewRepository.save(review3);

        System.out.println("DataLoader: Loading data completed");
    }
}
