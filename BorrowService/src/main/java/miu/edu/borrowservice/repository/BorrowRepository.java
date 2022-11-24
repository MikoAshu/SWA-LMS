package miu.edu.borrowservice.repository;

import miu.edu.borrowservice.domain.Borrow;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowRepository extends MongoRepository<Borrow, String> {
    Optional<List<Borrow>> findBorrowByCustomerNumber(String s);

    Optional<List<Borrow>> findBorrowByIsbn(String s);
}
