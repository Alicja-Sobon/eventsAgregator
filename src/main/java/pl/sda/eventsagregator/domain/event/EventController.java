package pl.sda.eventsagregator.domain.event;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.eventsagregator.domain.user.UserListView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final EventService service;

    @GetMapping
    public String getEvents(Model model) {
        List<EventListView> events = service.getAll();
        model.addAttribute("events", events);
        return "events-list";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addEvent(@RequestBody @Valid EventCreateRequest request) {
        service.addEvent(request);
    }
//
//    @GetMapping
//    public List<EventListView> getAll() {
//        return service.getAll();
//    }
//
//    @GetMapping("/{id")
//    public EventSingleView getById(@PathVariable Long id) {
//        return service.getById(id);
//    }
//
//    @PutMapping("/{id}")
//    public void updateEvent(@PathVariable Long id, @RequestBody EventCreateRequest request) {
//        service.update(id, request);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void removeEventById(@PathVariable Long id) {
//        service.remove(id);
//    }
}
