package pl.sda.eventsagregator.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import pl.sda.eventsagregator.domain.event.Event;

import java.util.List;
import java.util.stream.Collectors;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
interface UserMapper {

    UserMapper MAPPER = getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "events", ignore = true)
    })
    User toUser(UserCreateRequest request);

    UserListView toUserListView(User user);

    UserSingleView toUserSingleView(User user);

    @Mappings({
            @Mapping(target = "events", source = "events", qualifiedByName = "mapToEventsTitles")
    })
    OrganizerListView toOrganizerListView(User user);

    @Named("mapToEventsTitles")
    default String mapToOrganizerEventListView(List<Event> events) {
        return events.stream().map(Event::getTitle).collect(Collectors.joining(", "));
    }
}
