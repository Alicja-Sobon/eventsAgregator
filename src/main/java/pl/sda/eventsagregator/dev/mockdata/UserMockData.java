package pl.sda.eventsagregator.dev.mockdata;

import pl.sda.eventsagregator.domain.user.Role;

import java.util.List;

public class UserMockData {

    static final List<String> USERNAMES = List.of("alicja-policja", "borys kutia", "anita anitamta", "tomasz tegoniemasz", "adam aniedam");
    static final List<String> PASSWORDS = List.of("12345678A", "wszystkoCzegoDzisChcesz", "LaCasaDePapel", "12wody34", "gbuycgauyegc7");
    static final List<Role> ROLES = List.of(Role.A, Role.O, Role.U);

    static final Integer USERNAMES_COUNT = USERNAMES.size();
    static final Integer PASSWORDS_COUNT = PASSWORDS.size();
    static final Integer ROLES_COUNT = ROLES.size();
}
