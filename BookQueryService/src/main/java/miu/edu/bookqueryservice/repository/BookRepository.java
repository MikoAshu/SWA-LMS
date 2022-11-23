package miu.edu.bookqueryservice.repository;

import miu.edu.bookqueryservice.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
