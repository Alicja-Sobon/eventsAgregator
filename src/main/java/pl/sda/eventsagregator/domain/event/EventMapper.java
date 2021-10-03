package pl.sda.eventsagregator.domain.event;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
interface EventMapper {

    EventMapper MAPPER = getMapper(EventMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),

    })
    Event toEvent(EventCreateRequest request);

    EventListView toEventListView(Event event);

    EventSingleView toEventSingleView(Event event);
}
