package me.guillaume.chuck_facts.infrastructure.persistence;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table
public class NotificationChannels {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String type;
    private String destination;

    public NotificationChannels() {
        // JPA
    }

    public NotificationChannels(String name, String type, String destination) {
        this.name = name;
        this.type = type;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
