package me.guillaume.chuck_facts.application;

import me.guillaume.chuck_facts.infrastructure.persistence.Users;
import me.guillaume.chuck_facts.infrastructure.persistence.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public List<Users> users() {
        return repository.findAll();
    }

    public void delete(Long usersId) {
        Optional<Users> users = repository.findById(usersId);
        users.ifPresent(repository::delete);
    }

    public void create(String users, String password, String email) {
        // FIXME : check if not already present
        repository.save(new Users(users, password, email));
    }
}
