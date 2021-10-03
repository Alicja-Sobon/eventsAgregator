package pl.sda.eventsagregator.domain.comment;

import lombok.Value;
import pl.sda.eventsagregator.domain.user.User;

@Value
public class CommentSingleView {

    private User user;

    private String message;
}
