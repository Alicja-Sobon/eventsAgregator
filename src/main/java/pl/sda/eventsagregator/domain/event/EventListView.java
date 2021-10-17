package pl.sda.eventsagregator.domain.event;

import lombok.Data;
import pl.sda.eventsagregator.domain.comment.Comment;
import pl.sda.eventsagregator.domain.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventListView {

    private String title;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    private String description;

//    private User organizer;
//
//    private List<User> attendants = new ArrayList<>();
//
//    private List<Comment> comments = new ArrayList<>();
}
