package pl.sda.eventsagregator.domain.comment

import spock.lang.Specification

class CommentMapperSpec extends Specification {

    def 'should map CommentCreateRequest to Comment'() {
        given:
        def request = new CommentCreateRequest(null, "ale, ale fajnie")

        when:
        def result = CommentMapper.MAPPER.toComment(request)

        then:
        result.message == request.message
    }

    def 'should map Comment to CommentListView'() {
        given:
        def comment = new Comment(1L, null, "idę w ciemno")

        when:
        def result = CommentMapper.MAPPER.toCommentListView(comment)

        then:
        result.user == comment.user
        result.message == comment.message
    }

    def 'should map Comment to CommentSingleView'() {
        given:
        def comment = new Comment(2L, null, "czemu tydzień ma tylko 7 dni?")

        when:
        def result = CommentMapper.MAPPER.toCommentSingleView(comment)

        then:
        result.user == comment.user
        result.message == comment.message
    }
}
