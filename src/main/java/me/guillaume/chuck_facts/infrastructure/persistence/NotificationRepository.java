package me.guillaume.chuck_facts.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    Notification findById(long id);
    void deleteById(long id);
    Notification findByDate(Date date);
}
