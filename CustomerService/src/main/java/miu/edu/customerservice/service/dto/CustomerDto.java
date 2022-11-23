package miu.edu.customerservice.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class CustomerDto {

    private String customerNumber;

    private String name;

    @JsonProperty("address")
    private AddressDto addressDto;

    @JsonProperty("contact")
    private ContactDto contactDto;

}
