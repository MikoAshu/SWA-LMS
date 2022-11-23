package miu.edu.borrowservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class FeignClients {
    @FeignClient(name = "CustomerService")
    interface CustomerClient {
        @GetMapping("/customer/{customerNumber}")
        CustomerDto getCustomer(@PathVariable String customerNumber);
    }

    @FeignClient(name = "BookQueryService")
    interface BookQueryClient {
        @GetMapping("/book/{isbn}")
        BookDto getBook(@PathVariable String isbn);
    }
}
