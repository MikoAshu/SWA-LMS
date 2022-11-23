package miu.edu.bookqueryservice.repository;

import miu.edu.bookqueryservice.domain.Book;
import miu.edu.bookqueryservice.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findByIsbnAndReviewsContaining(String isbn, Review review);
}
