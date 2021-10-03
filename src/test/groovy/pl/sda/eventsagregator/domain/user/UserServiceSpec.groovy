package pl.sda.eventsagregator.domain.user

import spock.lang.Specification


class UserServiceSpec extends Specification {

    def repository = Mock(UserRepository)
    def service = new UserService(repository)

}
