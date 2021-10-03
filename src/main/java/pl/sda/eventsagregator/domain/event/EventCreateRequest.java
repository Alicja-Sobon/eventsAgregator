package pl.sda.eventsagregator.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import pl.sda.eventsagregator.domain.comment.Comment;
import pl.sda.eventsagregator.domain.user.User;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private User organizer;
}
