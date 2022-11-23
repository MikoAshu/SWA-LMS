package miu.edu.customerservice.service;


import miu.edu.customerservice.domain.Customer;
import miu.edu.customerservice.service.dto.CustomerDto;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto);
    Customer getCustomer(String customerNumber);
    void updateCustomer(CustomerDto customerDto);
    void deleteCustomer(String customerNumber);
}
