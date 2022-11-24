package miu.edu.customerservice.domain.seeder;

import miu.edu.customerservice.domain.Address;
import miu.edu.customerservice.domain.Contact;
import miu.edu.customerservice.domain.Customer;
import miu.edu.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("DataLoader is running");

        customerRepository.deleteAll();
        Address address1 = new Address("1234", "Fairfield", "52557");
        Address address2 = new Address("1235", "Fairfield", "52557");
        Contact contact1 = new Contact("515-555-5555", "test@test.com");
        Contact contact2 = new Contact("515-555-5556", "test2@test.com");

        Customer customer = new Customer( "1234567890", "John Doe", address1, contact1);
        Customer customer2 = new Customer( "1234567891", "Jane Doe", address2, contact2);
        Customer customer3 = new Customer( "1234567892", "Abel Tadesse", address2, contact2);

//        customerRepository.save(customer);
//        customerRepository.save(customer2);
//        customerRepository.save(customer3);
    }
}
