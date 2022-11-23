package miu.edu.borrowservice.service.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import miu.edu.borrowservice.service.CustomerDto;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerChangeEventDto {
    private ChangeEventType event;
    private CustomerDto customerDto;
}
