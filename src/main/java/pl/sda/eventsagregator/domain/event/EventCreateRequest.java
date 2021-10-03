package pl.sda.eventsagregator.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventCreateRequest {

    @NotBlank(message = "Title can not be empty nor blank")
    private String title;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    @Range(min = 20, message = "Your description should be min 20 characters long")
    private String description;

    private Long organizerId;
}
