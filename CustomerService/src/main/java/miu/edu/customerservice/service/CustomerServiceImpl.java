package miu.edu.customerservice.service;

import miu.edu.customerservice.domain.Customer;
import miu.edu.customerservice.exception.CustomException;
import miu.edu.customerservice.integration.EventPublisher;
import miu.edu.customerservice.repository.CustomerRepository;
import miu.edu.customerservice.service.dto.ChangeEventType;
import miu.edu.customerservice.service.dto.CustomerAdapter;
import miu.edu.customerservice.service.dto.CustomerChangeEventDto;
import miu.edu.customerservice.service.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerAdapter.toCustomer(customerDto);
        customerRepository.save(customer);
        CustomerChangeEventDto customerChangeEventDto = new CustomerChangeEventDto(ChangeEventType.CREATE, customerDto);
        eventPublisher.publish(customerChangeEventDto);

    }

    @Override
    public Customer getCustomer(String customerNumber) {
        Optional<Customer> customer = customerRepository.findById(customerNumber);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            throw new CustomException("Customer Not Found", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        Optional<Customer> customerOptional = customerRepository.findById(customerDto.getCustomerNumber());
        if (customerOptional.isPresent()) {
            Customer customer1 = CustomerAdapter.toCustomer(customerDto);
            customerRepository.save(customer1);
            CustomerChangeEventDto customerChangeEventDto = new CustomerChangeEventDto(ChangeEventType.UPDATE, customerDto);
            eventPublisher.publish(customerChangeEventDto);
        } else {
            throw new CustomException("Customer Not Found", HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    public void deleteCustomer(String customerNumber) {
        Optional<Customer> customer = customerRepository.findById(customerNumber);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
            CustomerChangeEventDto customerChangeEventDto = new CustomerChangeEventDto(ChangeEventType.DELETE, CustomerAdapter.toCustomerDto(customer.get()));
            eventPublisher.publish(customerChangeEventDto);
        } else {
            throw new CustomException("Customer Not Found", HttpStatus.BAD_REQUEST);
        }
    }
}
