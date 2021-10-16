package pl.sda.eventsagregator.domain.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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
}
