package miu.edu.bookcommandservice.repository;

import miu.edu.bookcommandservice.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
