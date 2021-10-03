package pl.sda.eventsagregator.domain.event;

import pl.sda.eventsagregator.core.exception.NotFoundException;

public class EventNotFoundException extends NotFoundException {
    public EventNotFoundException(Long id) {
        super("Event with id " + id + " was not found");
    }
}
