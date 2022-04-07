package me.guillaume.chuck_facts.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByName(String name);
    Users findByEmailAndPassword(String email, String password);
}
