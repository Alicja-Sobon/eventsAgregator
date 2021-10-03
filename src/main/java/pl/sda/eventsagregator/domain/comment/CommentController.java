package pl.sda.eventsagregator.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addComment(@RequestBody @Valid CommentCreateRequest request) {
        service.addComment(request);
    }

    @GetMapping
    public List<CommentListView> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id")
    public CommentSingleView getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentCreateRequest request) {
        service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEventById(@PathVariable Long id) {
        service.remove(id);
    }
}
