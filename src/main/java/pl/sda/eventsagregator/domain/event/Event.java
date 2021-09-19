package pl.sda.eventsagregator.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import pl.sda.eventsagregator.domain.comment.Comment;
import pl.sda.eventsagregator.domain.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Title can not be empty nor blank")
    private String title;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    @Range(min = 20, message = "Your description should be min 20 characters long")
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User organizer;

    //TODO will be implemented by EA-4

    @ManyToMany
    @JoinTable(
            name = "event_attendants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> attendants = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "event_comments",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private List<Comment> comments = new ArrayList<>();


}
