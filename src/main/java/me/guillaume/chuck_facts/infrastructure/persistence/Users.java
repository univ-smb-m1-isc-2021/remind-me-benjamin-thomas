package me.guillaume.chuck_facts.infrastructure.persistence;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String password;
    private String email;

    @OneToMany
    private List<Notification> notifications;

    public Users() {
        // JPA
    }

    public Users(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Users(Users myUser) {
        this.name = myUser.getName();
        this.password = myUser.getPassword();
        this.email = myUser.getEmail();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
