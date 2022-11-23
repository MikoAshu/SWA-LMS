package miu.edu.borrowservice.domain.seeder;

import miu.edu.borrowservice.domain.Borrow;
import miu.edu.borrowservice.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("DataLoader is running");
        Borrow borrow1 = new Borrow("121212", LocalDate.now(), "1234567890", "John Doe", "1234567890", "Java");
        Borrow borrow2 = new Borrow("121213", LocalDate.now(), "1234567891", "Jaina Proudmoore", "1234567891", "C#");
        Borrow borrow3 = new Borrow("121214", LocalDate.now(), "1234567892", "Arthas", "1234567892", "Python");
        borrowRepository.save(borrow1);
        borrowRepository.save(borrow2);
        borrowRepository.save(borrow3);
    }
}
