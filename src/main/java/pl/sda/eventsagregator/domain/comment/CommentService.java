package pl.sda.eventsagregator.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.eventsagregator.domain.user.User;
import pl.sda.eventsagregator.domain.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

import static pl.sda.eventsagregator.domain.comment.CommentMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repository;
    private final UserService userService;

    public void addComment(CommentCreateRequest request) {
        Comment comment = CommentMapper.MAPPER.toComment(request);
        User user = userService.findById(request.getUserId());
        comment.setUser(user);
        repository.save(comment);
    }

    public List<CommentListView> getAll() {
        return repository
                .findAll()
                .stream()
                .map(MAPPER::toCommentListView)
                .collect(Collectors.toList());
    }

    public CommentSingleView getById(Long id) {
        return MAPPER.toCommentSingleView(findById(id));
    }

    Comment findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new CommentNotFoundException(id));
    }

    void update(Long id, CommentCreateRequest request) {
        Comment comment = findById(id);
        comment.setMessage(request.getMessage());
        repository.save(comment);
    }

    public void remove(Long id) {
        repository.delete(findById(id));
    }
}
