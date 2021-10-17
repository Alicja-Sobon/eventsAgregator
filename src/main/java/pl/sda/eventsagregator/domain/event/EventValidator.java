package pl.sda.eventsagregator.domain.event;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
class EventValidator {

    public void validate(EventCreateRequest request) {
        LocalDateTime startDate = request.getStartDate();
        LocalDateTime finishDate = request.getFinishDate();

        if(finishDate.isBefore(startDate)) {
            throw new IllegalArgumentException("Start date cannot be before end date");
        }
    }
}
