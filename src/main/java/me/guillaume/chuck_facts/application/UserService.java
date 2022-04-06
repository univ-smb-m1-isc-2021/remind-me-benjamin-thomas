package me.guillaume.chuck_facts.application;

import me.guillaume.chuck_facts.infrastructure.persistence.User;
import me.guillaume.chuck_facts.infrastructure.persistence.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> users() {
        return repository.findAll();
    }

    public void delete(Long userId) {
        Optional<User> user = repository.findById(userId);
        user.ifPresent(repository::delete);
    }

    public void create(String user, String password, String email) {
        // FIXME : check if not already present
        repository.save(new User(user, password, email));
    }
}
