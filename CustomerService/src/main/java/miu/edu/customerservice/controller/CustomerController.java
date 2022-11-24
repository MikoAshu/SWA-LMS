package miu.edu.customerservice.controller;

import miu.edu.customerservice.service.CustomerService;
import miu.edu.customerservice.service.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable String customerNumber) {
        return ResponseEntity.ok(customerService.getCustomer(customerNumber));
    }

    @PostMapping("")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("")
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{customerNumber}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String customerNumber) {
        customerService.deleteCustomer(customerNumber);
        return ResponseEntity.ok().build();
    }

}
