package pl.sda.eventsagregator.domain.user;

import lombok.Data;

@Data
public class UserListView {

    Long id;

    String username;

    Role role;
}
