package pl.sda.eventsagregator.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @GetMapping
    public String getUsers(Model model) {
        List<UserListView> users = service.getAll();
        model.addAttribute("users", users);
        return "users-list";
    }

    @GetMapping("/organizers")
    public String getOrganizers(Model model) {
        List<OrganizerListView> organizers = service.getAllOrganizers();
        model.addAttribute("organizers", organizers);
        return "organizers-list";

    }

//    @PostMapping("/add-user")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addUser(@RequestBody @Valid UserCreateRequest request) {
//        service.addUser(request);
//    }

//    @GetMapping
//    public List<UserListView> getAll() {
//        return service.getAll();
//    }

//    @GetMapping("/{id}")
//    public UserSingleView getById(@PathVariable Long id) {
//        return service.getById(id);
//    }
//
//    @PutMapping("/{id}")
//    public void updateUser(@PathVariable Long id, @RequestBody UserCreateRequest request) {
//        service.update(id, request);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void removeUserById(@PathVariable Long id) {
//        service.remove(id);
//    }
}
