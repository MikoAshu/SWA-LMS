package miu.edu.borrowservice.service;

import miu.edu.borrowservice.domain.Borrow;
import miu.edu.borrowservice.exception.CustomException;
import miu.edu.borrowservice.integration.EventPublisher;
import miu.edu.borrowservice.repository.BorrowRepository;
import miu.edu.borrowservice.service.event.BorrowChangeEventDto;
import miu.edu.borrowservice.service.event.ChangeEventType;
import org.apache.coyote.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private EventPublisher eventPublisher;

    @Autowired
    BorrowRepository borrowRepository;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private BookQueryClient bookClient;

    @Override
    public List<BorrowDto> getBorrow(String isbn) {
        Optional<List<Borrow>> borrow = borrowRepository.findBorrowByIsbn(isbn);
        if (borrow.isPresent()) {
            List<Borrow> borrows = borrow.get();
            List<BorrowDto> borrowDtos = BorrowAdapter.toBorrowDtoList(borrows);
            return borrowDtos;
        } else {
            throw new CustomException("Borrow not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void addBorrow(String isbn, String customerNumber) {
        CustomerDto customerDto = customerClient.getCustomer(customerNumber);
        BookDto bookDto = bookClient.getBook(isbn);

        if (customerDto == null) {
            throw new CustomException("Customer not found", HttpStatus.NOT_FOUND);
        }
        if (bookDto == null) {
            throw new CustomException("Book not found", HttpStatus.NOT_FOUND);
        }

        Borrow borrow = new Borrow(
                String.valueOf(new Random().nextInt(100000)),
                new Date(),
                customerNumber,
                customerDto.getName(),
                isbn,
                bookDto.getTitle());
        borrowRepository.save(borrow);
        BorrowChangeEventDto borrowChangeEventDto = new BorrowChangeEventDto(ChangeEventType.CREATE, BorrowAdapter.toBorrowDto(borrow));
        eventPublisher.publish(borrowChangeEventDto);
    }

    @Override
    public BorrowDto updateBorrow(BorrowDto borrowDto) {
        Optional<Borrow> borrowOptional = borrowRepository.findById(borrowDto.getBorrowingNumber());
        if (borrowOptional.isPresent()) {
            borrowRepository.save(borrowOptional.get());
            BorrowChangeEventDto borrowChangeEventDto = new BorrowChangeEventDto(ChangeEventType.UPDATE, borrowDto);
            eventPublisher.publish(borrowChangeEventDto);
            return borrowDto;
        } else {
            throw new CustomException("Borrow not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void updateBorrow(BookDto bookDto) {
        Optional<List<Borrow>> borrowOptional = borrowRepository.findBorrowByIsbn(bookDto.getIsbn());
        if (borrowOptional.isPresent()) {
            List<Borrow> borrows = borrowOptional.get();
            for (Borrow borrow : borrows) {
                borrow.setBookTitle(bookDto.getTitle());
                borrowRepository.save(borrow);
                BorrowChangeEventDto borrowChangeEventDto = new BorrowChangeEventDto(ChangeEventType.UPDATE, BorrowAdapter.toBorrowDto(borrow));
                eventPublisher.publish(borrowChangeEventDto);
            }
        }
    }

    @Override
    public void updateBorrow(CustomerDto customerDto) {
            Optional<List<Borrow>> borrowOptional = borrowRepository.findBorrowByCustomerNumber(customerDto.getCustomerNumber());
            if (borrowOptional.isPresent()) {
                List<Borrow> borrows = borrowOptional.get();
                for (Borrow borrow : borrows) {
                    borrow.setCustomerName(customerDto.getName());
                    borrowRepository.save(borrow);
                    BorrowChangeEventDto borrowChangeEventDto = new BorrowChangeEventDto(ChangeEventType.UPDATE, BorrowAdapter.toBorrowDto(borrow));
                    eventPublisher.publish(borrowChangeEventDto);
                }
            }
    }

    @Override
    public BorrowDto deleteBorrow(String isbn) {
        Optional<Borrow> borrow = borrowRepository.findById(isbn);
        if (borrow.isPresent()) {
            borrowRepository.delete(borrow.get());
            BorrowDto borrowDto = BorrowAdapter.toBorrowDto(borrow.get());
            BorrowChangeEventDto borrowChangeEventDto = new BorrowChangeEventDto(
                    ChangeEventType.DELETE, borrowDto);
            eventPublisher.publish(borrowChangeEventDto);
            return borrowDto;
        } else {
            throw new CustomException( "Borrow not found",HttpStatus.NOT_FOUND);
        }

    }

    @FeignClient(name = "CustomerService")
    interface CustomerClient {
        @GetMapping("/customers/{customerNumber}")
        CustomerDto getCustomer(@PathVariable String customerNumber);
    }

    @FeignClient(name = "BookQueryService")
    interface BookQueryClient {
        @GetMapping("/books/{isbn}")
        BookDto getBook(@PathVariable String isbn);
    }
}
