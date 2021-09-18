package pl.sda.eventsagregator.domain.user;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


}
