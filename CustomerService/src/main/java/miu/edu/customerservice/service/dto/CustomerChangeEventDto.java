package miu.edu.customerservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class CustomerChangeEventDto {
    private ChangeEventType event;
    private CustomerDto customerDto;
}
