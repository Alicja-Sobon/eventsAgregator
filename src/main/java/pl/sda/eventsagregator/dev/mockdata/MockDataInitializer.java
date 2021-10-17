package pl.sda.eventsagregator.dev.mockdata;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.eventsagregator.domain.comment.CommentCreateRequest;
import pl.sda.eventsagregator.domain.comment.CommentService;
import pl.sda.eventsagregator.domain.event.EventCreateRequest;
import pl.sda.eventsagregator.domain.event.EventService;
import pl.sda.eventsagregator.domain.user.OrganizerListView;
import pl.sda.eventsagregator.domain.user.UserCreateRequest;
import pl.sda.eventsagregator.domain.user.UserService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static pl.sda.eventsagregator.dev.mockdata.CommentMockData.MESSAGES;
import static pl.sda.eventsagregator.dev.mockdata.CommentMockData.MESSAGES_COUNT;
import static pl.sda.eventsagregator.dev.mockdata.EventMockData.*;
import static pl.sda.eventsagregator.dev.mockdata.UserMockData.*;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class MockDataInitializer {

    @Value("${users.mock.count}")
    private short count;

    private final UserService userService;
    private final EventService eventService;
    private final CommentService commentService;

    private final Random random = new Random();

    @PostConstruct
    void initializeData() {
        initializeUsers();
        initializeEvents();
        initializeComments();
    }

    void initializeUsers() {
        for (int i = 0; i < count; i++) {
            userService.addUser(new UserCreateRequest(
                    USERNAMES.get(random.nextInt(USERNAMES_COUNT)),
                    PASSWORDS.get(random.nextInt(PASSWORDS_COUNT)),
                    ROLES.get(random.nextInt(ROLES_COUNT))));
        }
    }

    void initializeEvents() {
        List<Long> organizerIds = userService.getAllOrganizers().stream()
                .map(OrganizerListView::getId)
                .collect(toList());

        for (int i = 0; i < count; i++) {
            eventService.addEvent(new EventCreateRequest(
                    TITLES.get(random.nextInt(TITLES_COUNT)),
                    START_DATES.get(random.nextInt(START_DATES_COUNT)),
                    FINISH_DATES.get(random.nextInt(FINISH_DATES_COUNT)),
                    DESCRIPTIONS.get(random.nextInt(DESCRIPTIONS_COUNT)),
                    organizerIds.get(random.nextInt(organizerIds.size()))));
        }
    }

    void initializeComments() {
        List<Long> userIds = IntStream.rangeClosed(1, 10).boxed().map(Integer::longValue).collect(toList());

        for (int i = 0; i < count; i++) {
            commentService.addComment(new CommentCreateRequest(
                    userIds.get(random.nextInt(userIds.size())),
                    MESSAGES.get(random.nextInt(MESSAGES_COUNT))));
        }
    }
}
