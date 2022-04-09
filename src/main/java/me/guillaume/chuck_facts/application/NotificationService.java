package me.guillaume.chuck_facts.application;

import me.guillaume.chuck_facts.infrastructure.persistence.Notification;
import me.guillaume.chuck_facts.infrastructure.persistence.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Notification> Notification() {
        return repository.findAll();
    }

    public void delete(Long NotificationId) {
        Optional<Notification> Notification = repository.findById(NotificationId);
        Notification.ifPresent(repository::delete);
    }

    public void create(String name, String description, boolean repeat, int frequence) {
        // FIXME : check if not already present
        repository.save(new Notification(name, description, new Date(),repeat, frequence));
    }
}
