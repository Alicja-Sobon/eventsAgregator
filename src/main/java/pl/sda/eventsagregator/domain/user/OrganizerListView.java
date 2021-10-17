package pl.sda.eventsagregator.domain.user;

import lombok.Data;

import java.util.List;

@Data
public class OrganizerListView {

    Long id;

    String username;

    String events;
}
