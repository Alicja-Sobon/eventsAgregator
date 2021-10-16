package pl.sda.eventsagregator.domain.user;

import lombok.Data;
import pl.sda.eventsagregator.domain.event.Event;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserListView {

    String username;

    Role role;

    //    @OneToMany(mappedBy = "organizer")
    List<Event> events = new ArrayList<>();
}
