package pl.sda.eventsagregator.domain.comment;

import lombok.Data;
import pl.sda.eventsagregator.domain.user.User;

@Data
public class CommentListView {

    private User user;

    private String message;
}
