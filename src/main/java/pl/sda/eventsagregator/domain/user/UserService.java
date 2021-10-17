package pl.sda.eventsagregator.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static pl.sda.eventsagregator.domain.user.UserMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;


    public void addUser(UserCreateRequest request) {
        User user = MAPPER.toUser(request);
        repository.save(user);
    }

    public List<UserListView> getAll() {
        return repository
                .findAll()
                .stream()
                .map(MAPPER::toUserListView)
                .collect(Collectors.toList());
    }

    public UserSingleView getById(Long id) {
        return MAPPER.toUserSingleView(findById(id));
    }

    public User findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    void update(Long id, UserCreateRequest request) {
        User user = findById(id);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        repository.save(user);
    }

    public void remove(Long id) {
        repository.delete(findById(id));
    }
}
