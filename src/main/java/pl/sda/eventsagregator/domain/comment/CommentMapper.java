package pl.sda.eventsagregator.domain.comment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
interface CommentMapper {

    CommentMapper MAPPER = getMapper(CommentMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),

    })
    Comment toComment(CommentCreateRequest request);

    CommentListView toCommentListView(Comment comment);

    CommentSingleView toCommentSingleView(Comment comment);
}
