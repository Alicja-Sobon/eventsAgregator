package pl.sda.eventsagregator.domain.user;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    A("admin"), O("organizer"), U("user");

    private String role;
}
