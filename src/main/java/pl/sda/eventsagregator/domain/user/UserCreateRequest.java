package pl.sda.eventsagregator.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {

    @NotEmpty(message = "Username is required")
    @Range(min = 1, max = 50, message = "Username must be between 1 and 50 characters long")
    String username;

    @NotEmpty(message = "Password is required")
    @NotBlank(message = "Password can not be blank")
    @Range(min = 8, max = 30, message = "Password must be between 8 and 30 characters long")
    String password;

    Role role;

//    @OneToMany(mappedBy = "organizer")
//    List<Event> events = new ArrayList<>();
}
