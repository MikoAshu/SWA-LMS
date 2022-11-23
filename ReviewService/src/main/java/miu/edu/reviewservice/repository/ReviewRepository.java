package miu.edu.reviewservice.repository;

import miu.edu.reviewservice.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
