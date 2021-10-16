package pl.sda.eventsagregator.domain.user;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    ADMIN("admin"), ORGANIZER("organizer"), USER("user");

    private String role;
}
