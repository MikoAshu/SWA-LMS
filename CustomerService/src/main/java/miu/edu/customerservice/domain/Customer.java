package miu.edu.customerservice.domain;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "customers")
public class Customer {
    @Id
    private String customerNumber;

    private String name;

    private Address address;

    private Contact contact;
}
