package pl.sda.eventsagregator.domain.event

import spock.lang.Specification

import java.time.LocalDateTime

class EventMapperSpec extends Specification {

    def 'should map EventCreateRequest to Event'() {
        given:
        def request = new EventCreateRequest("bieg", LocalDateTime.MIN, LocalDateTime.MAX, "bieg wokół komina", null)

        when:
        def result = EventMapper.MAPPER.toEvent(request)

        then:
        result.title == request.title
        result.startDate == request.startDate
        result.finishDate == request.finishDate
        result.description == request.description
        result.organizer == request.organizer
    }

    def 'should map Event to EventListView'() {
        given:
        def event = new Event(1L, "urlop", LocalDateTime.MIN, LocalDateTime.MAX, "wypoczynek", null, [], [])

        when:
        def result = EventMapper.MAPPER.toEventListView(event)

        then:
        result.title == event.title
        result.startDate == event.startDate
        result.finishDate == event.finishDate
        result.description == event.description
        result.organizer == event.organizer
    }

    def 'should map Event to EventSingleView'() {
        given:
        def event = new Event(1L, "hell", LocalDateTime.MIN, LocalDateTime.MAX, "go to hell", null, [], [])

        when:
        def result = EventMapper.MAPPER.toEventSingleView(event)

        then:
        result.title == event.title
        result.startDate == event.startDate
        result.finishDate == event.finishDate
        result.description == event.description
        result.organizer == event.organizer
        result.attendants == []
        result.comments == []
    }
}
