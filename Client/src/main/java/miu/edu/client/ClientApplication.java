package miu.edu.client;

import miu.edu.client.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Autowired
    private RestOperations restTemplate;

    @Override
    public void run(String... args) throws Exception {
    System.out.println("Client is running");
    String borrowUrl = "http://localhost:80/borrows";
    String bookUrl = "http://localhost:80/books";
    String customerUrl = "http://localhost:80/customers";
    String reviewUrl = "http://localhost:80/reviews";

        /*
        1. Add 2 customers to the customer service
2. Add 2 books to the bookcommand service
3. Add 2 reviews for every book in the review service, one review per customer
4. Get all books from the booksquery service with all the information of the books and print it to the console.
5. Add a borrowing to the borrowingservice for a book and a customer
6. Change the title of this book that is borrowed
7. Get this book from the booksquery service and check if the title has changed
8. Get the corresponding borrowing and check if the book title has changed
         */
        System.out.println("======================================================================");
        System.out.println("======================================================================");
        // 1. Add 2 customers to the customer service
        System.out.println("1. Add 2 customers to the customer service");

        AddressDto address1 = new AddressDto("1234", "Fairfield", "52557");
        AddressDto address2 = new AddressDto("1235", "Fairfield", "52557");

        ContactDto contact1 = new ContactDto("515-555-5555", "test@test.com");
        ContactDto contact2 = new ContactDto("515-555-5556", "test2@test.com");

        CustomerDto customer = new CustomerDto( "123456789011", "John Doe", address1, contact1);
        CustomerDto customer2 = new CustomerDto( "123456789111", "Jane Doe", address2, contact2);

        restTemplate.postForLocation(customerUrl, customer);
        restTemplate.postForLocation(customerUrl, customer2);

        // 2. Add 2 books to the bookcommand service
        System.out.println("======================================================================");
        System.out.println("======================================================================");
        System.out.println("2. Add 2 books to the bookcommand service");

        BookDto book1 = new BookDto("1234567890", "Java", "Java Book", "Author 1");
        BookDto book2 = new BookDto("1234567891", "C#", "C# Book", "Author 2");

        restTemplate.postForLocation(bookUrl, book1);
        restTemplate.postForLocation(bookUrl, book2);
        System.out.println("Added 2 books to the bookcommand service");

        // 3. Add 2 reviews for every book in the review service, one review per customer
        System.out.println("======================================================================");
        System.out.println("======================================================================");
        System.out.println("3. Add 2 reviews for every book in the review service, one review per customer");
        ReviewDto reviewDto1 = new ReviewDto( "1234567890",5,  "Daniel Adam", "Great book");
        ReviewDto reviewDto2 = new ReviewDto( "1234567890",4,  "Rose Ken", "Good book");

        ReviewDto reviewDto3 = new ReviewDto( "1234567891",5,  "Daniel Adam", "Great book");
        ReviewDto reviewDto4 = new ReviewDto( "1234567891",4,  "Rose Ken", "Good book");

        restTemplate.postForLocation(reviewUrl, reviewDto1);
        restTemplate.postForLocation(reviewUrl, reviewDto2);
        restTemplate.postForLocation(reviewUrl, reviewDto3);
        restTemplate.postForLocation(reviewUrl, reviewDto4);

        System.out.println("Added 2 reviews for every book in the review service, one review per customer");
        // 4. Get all books from the booksquery service with all the information of the books and print it to the console.
        System.out.println("======================================================================");
        System.out.println("======================================================================");
        System.out.println("4. Get all books from the booksquery service with all the information of the books and print it to the console.");
        BookDto[] booksQuery = restTemplate.getForObject(bookUrl, BookDto[].class);
        assert booksQuery != null;
        Arrays.stream(booksQuery).peek(System.out::println).collect(Collectors.toList());

        // 5. Add a borrowing to the borrowingservice for a book and a customer
        System.out.println("======================================================================");
        System.out.println("======================================================================");
        System.out.println("5. Add a borrowing to the borrowingservice for a book and a customer");

        BorrowDto borrow1 = new BorrowDto("121212", new Date(), "1234567890", "John Doe", "1234567890", "Java");
        restTemplate.postForLocation(borrowUrl+"/1234567890/123456789011", borrow1);

        System.out.println("Added a borrowing to the borrowingservice for a book and a customer");
        // 6. Change the title of this book that is borrowed
        System.out.println("======================================================================");
        System.out.println("======================================================================");
        System.out.println("6. Change the title of this book that is borrowed");
        book1.setTitle("Java 8");
        restTemplate.put(bookUrl, book1);
        System.out.println("Changed the title of this book that is borrowed");

        // 7. Get this book from the booksquery service and check if the title has changed
        System.out.println("======================================================================");
        System.out.println("======================================================================");
        System.out.println("7. Get this book from the booksquery service and check if the title has changed");
        BookDto bookQuery = restTemplate.getForObject(bookUrl+"/1234567890", BookDto.class);
        System.out.println(bookQuery);

        // 8. Get the corresponding borrowing and check if the book title has changed
        System.out.println("======================================================================");
        System.out.println("======================================================================");
        System.out.println("8. Get the corresponding borrowing and check if the book title has changed");
        BorrowDto[] borrowQuery = restTemplate.getForObject(borrowUrl+ "/1234567890", BorrowDto[].class);
        assert borrowQuery != null;
        Arrays.stream(borrowQuery).peek(System.out::println).collect(Collectors.toList());
    }

}
