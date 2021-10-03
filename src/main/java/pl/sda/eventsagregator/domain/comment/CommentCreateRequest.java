package pl.sda.eventsagregator.domain.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.eventsagregator.domain.user.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateRequest {

    private User user;

    private String message;
}
