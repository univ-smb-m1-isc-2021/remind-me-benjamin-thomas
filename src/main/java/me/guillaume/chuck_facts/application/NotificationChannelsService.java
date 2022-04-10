package me.guillaume.chuck_facts.application;

import me.guillaume.chuck_facts.infrastructure.persistence.NotificationChannels;
import me.guillaume.chuck_facts.infrastructure.persistence.NotificationChannelsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationChannelsService {

    private final NotificationChannelsRepository repository;

    public NotificationChannelsService(NotificationChannelsRepository repository) {
        this.repository = repository;
    }

    public List<NotificationChannels> NotificationChannels() {
        return repository.findAll();
    }

    public void delete(Long NotificationId) {
        Optional<NotificationChannels> Notification = repository.findById(NotificationId);
        Notification.ifPresent(repository::delete);
    }

    public void create(String name, String type, String destination) {
        // FIXME : check if not already present
        repository.save(new NotificationChannels(name, type, destination));
    }
}
