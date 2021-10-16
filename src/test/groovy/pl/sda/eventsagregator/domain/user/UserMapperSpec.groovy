package pl.sda.eventsagregator.domain.user

import spock.lang.Specification

class UserMapperSpec extends Specification{

    def 'should map UserCreateRequest to User'(){
        given:
        def request = new UserCreateRequest("alicja", "policja")

        when:
        def result = UserMapper.MAPPER.toUser(request)

        then:
        result.username == request.username
        result.password == request.password

    }

    def 'should map User to UserListView'(){
        given:
        def user = new User(1L,"Małgorzata", "queen123", Role.USER, [])

        when:
        def result = UserMapper.MAPPER.toUserListView(user)

        then:
        result.username == user.username
        result.events == []
    }

    def 'should map User to UserSingleView'(){
        given:
        def user = new User(1L, "Tatiana", "paSSword", Role.ADMIN, [])

        when:
        def result = UserMapper.MAPPER.toUserSingleView(user)

        then:
        result.username == user.username
        result.events == []
    }
}
