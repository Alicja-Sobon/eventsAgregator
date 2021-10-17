package pl.sda.eventsagregator.domain.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.eventsagregator.domain.user.User;
import pl.sda.eventsagregator.domain.user.UserService;

import java.util.List;
import java.util.stream.Collectors;

import static pl.sda.eventsagregator.domain.event.EventMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;
    private final EventValidator eventValidator;
    private final UserService userService;

    public void addEvent(EventCreateRequest request) {
        eventValidator.validate(request);
        Event event = MAPPER.toEvent(request);
        User organizer = userService.findById(request.getOrganizerId());
        event.setOrganizer(organizer);
        repository.save(event);
    }

    public List<EventListView> getAll() {
        return repository
                .findAll()
                .stream()
                .map(MAPPER::toEventListView)
                .collect(Collectors.toList());
    }

    public EventSingleView getById(Long id) {
        return MAPPER.toEventSingleView(findById(id));
    }

    Event findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    void update(Long id, EventCreateRequest request) {
        Event event = findById(id);
        event.setTitle(request.getTitle());
        event.setStartDate(request.getStartDate());
        event.setFinishDate(request.getFinishDate());
        event.setDescription(request.getDescription());
        repository.save(event);
    }

    public void remove(Long id) {
        repository.delete(findById(id));
    }
}
