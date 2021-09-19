package pl.sda.eventsagregator.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import pl.sda.eventsagregator.domain.event.Event;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username is required")
    @Range(min = 1, max = 50, message = "Username must be between 1 and 50 characters long")
    private String username;

    @NotEmpty(message = "Password is required")
    @NotBlank(message = "Password can not be blank")
    @Range(min = 8, max = 30, message = "Password must be between 8 and 30 characters long")
    private String password;

    private String role;

    @OneToMany(mappedBy = "organizer")
    private List<Event> events = new ArrayList<>();
}
