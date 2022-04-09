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
public class Notification {

    @Id
    @GeneratedValue
    private Long nid;

    private String name;
    private String description;
    private Date date;
    private boolean repeat;
    private int frequence;

    public Notification() {
        // JPA
    }

    public Notification(String name, String description, Date date , boolean repeat, int frequence) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.repeat = repeat;
        this.frequence = frequence;
    }

    public Long getId() {
        return nid;
    }

    public void setId(Long nid) {
        this.nid = nid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean repeat) {
        this.repeat = repeat;
    }

    public String getRepeatString() {
        if(repeat){
            return "true";
        }
        return "false";
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
}
