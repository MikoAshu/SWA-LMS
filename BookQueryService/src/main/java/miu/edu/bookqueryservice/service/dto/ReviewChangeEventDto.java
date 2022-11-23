package miu.edu.bookqueryservice.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ReviewChangeEventDto {
    private ChangeEventType event;
    private ReviewDto reviewDto;
}
