package miu.edu.customerservice.repository;

import miu.edu.customerservice.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
