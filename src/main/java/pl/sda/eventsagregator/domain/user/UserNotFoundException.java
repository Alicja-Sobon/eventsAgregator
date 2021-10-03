package pl.sda.eventsagregator.domain.user;

import pl.sda.eventsagregator.core.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super("User with id " + id + " was not found");
    }
}
