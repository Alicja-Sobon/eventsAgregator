package pl.sda.eventsagregator.domain.user;

import lombok.Value;
import pl.sda.eventsagregator.domain.event.Event;

import java.util.ArrayList;
import java.util.List;

@Value
class UserSingleView {

    private String username;

    private List<Event> events = new ArrayList<>();
}
