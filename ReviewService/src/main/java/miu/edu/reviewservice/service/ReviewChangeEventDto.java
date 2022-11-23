package miu.edu.reviewservice.service;

enum ChangeEventType {
    CREATE, UPDATE, DELETE
}

public class ReviewChangeEventDto {
    private final ChangeEventType event;
    private final ReviewDto reviewDto;

    public ReviewChangeEventDto(ChangeEventType event, ReviewDto reviewDto) {
        this.event = event;
        this.reviewDto = reviewDto;
    }

    public ChangeEventType getEvent() {
        return event;
    }

    public ReviewDto getReviewDto() {
        return reviewDto;
    }

    @Override
    public String toString() {
        return "ReviewChangeEventDto{" +
                "event=" + event +
                ", reviewDto=" + reviewDto +
                '}';
    }
}
