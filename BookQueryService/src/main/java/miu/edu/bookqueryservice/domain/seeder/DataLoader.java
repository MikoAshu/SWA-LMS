package miu.edu.bookqueryservice.domain.seeder;

import miu.edu.bookqueryservice.domain.Book;
import miu.edu.bookqueryservice.domain.Review;
import miu.edu.bookqueryservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("DataLoader: Loading data");
        bookRepository.deleteAll();
        Review review1 = new Review("637e945b9e800641567f33fc","1234567890",5,  "Daniel Adam", "Great book");
        Review review2 = new Review("637e945b9e800641567f33fd","1234567891",4,  "Rose Ken", "Good book");
        Review review3 = new Review("637e945b9e800641567f33fe","1234567892",3,  "Mil Shadow", "Average book");

        Book book1 = new Book("1234567890", "Java", "Java Book", "Author 1");
        Book book2 = new Book("1234567891", "C#", "C# Book", "Author 2");
        Book book3 = new Book("1234567892", "Python", "Python Book", "Author 3");

        book1.addReview(review1);
        book2.addReview(review2);
        book3.addReview(review3);

//        bookRepository.save(book1);
//        bookRepository.save(book2);
//        bookRepository.save(book3);

        System.out.println("DataLoader: Loading data completed");

    }
}
