package pl.sda.eventsagregator.domain.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EventController {

    private final EventService service;
}
