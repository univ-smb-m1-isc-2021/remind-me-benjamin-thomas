package me.guillaume.chuck_facts.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface NotificationChannelsRepository extends JpaRepository<NotificationChannels, Long> {

    NotificationChannels findById(long id);
    void deleteById(long id);
}
