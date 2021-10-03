package pl.sda.eventsagregator.domain.comment;

import pl.sda.eventsagregator.core.exception.NotFoundException;

public class CommentNotFoundException extends NotFoundException {
    public CommentNotFoundException(Long id) { super("Comment with id " + id + " was not found");
    }
}
