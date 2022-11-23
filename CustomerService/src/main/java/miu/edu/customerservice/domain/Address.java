package miu.edu.customerservice.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    private String street;
    private String city;
    private String zip;
}
