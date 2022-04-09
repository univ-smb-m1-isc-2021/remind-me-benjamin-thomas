package me.guillaume.chuck_facts.adapters.api;

import me.guillaume.chuck_facts.infrastructure.persistence.Notification;
import me.guillaume.chuck_facts.infrastructure.persistence.NotificationRepository;
import me.guillaume.chuck_facts.infrastructure.persistence.Users;
import me.guillaume.chuck_facts.infrastructure.persistence.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class NotificationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UsersRepository usersService;

    @Autowired
    NotificationRepository notificationService;

    @GetMapping(value = "/api/get_notification")
    public String getNotification(HttpServletRequest request) throws JSONException {
        logger.info("Serving Facts");
        Users temp = usersService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Notification> toReturn = temp.getNotifications();
        JSONArray json = new JSONArray();
        for (Notification el : toReturn) {
            JSONObject one = new JSONObject();
            one.put("id", el.getId());
            one.put("name", el.getName());
            one.put("description", el.getDescription());
            one.put("date", el.getDate());
            one.put("repeat", el.getRepeatString());
            one.put("frequence", String.valueOf(el.getFrequence()));
            json.put(one);
        }
        String toReturnString = json.toString();
        return toReturnString;
    }

    @GetMapping(value = "/api/delete_notification")
    public String deleteNotification(HttpServletRequest request, @RequestParam long id) {
        logger.info("Deleting");

        Users temp = usersService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Notification> toReturn = temp.getNotifications();

        for (Notification el : toReturn) {
            if(el.getId() == id){
                toReturn.remove(el);
                temp.setNotifications(toReturn);
                usersService.saveAndFlush(temp);
                notificationService.deleteById(id);
                return "DONE";
            }
        }

        return "Nothing to delete";
    }

    @GetMapping(value = "/api/create_notification")
    public String createNotification(HttpServletRequest request, @RequestParam String name, @RequestParam String description, @RequestParam String date, @RequestParam Boolean repeat, @RequestParam int frequence) throws ParseException {
        logger.info("Creating");
        Users temp = usersService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Notification> toReturn = temp.getNotifications();

        Date dateObj = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        Notification newNotif = notificationService.saveAndFlush(new Notification(name, description, dateObj, repeat, frequence));
        toReturn.add(newNotif);

        temp.setNotifications(toReturn);
        usersService.saveAndFlush(temp);
        return "Ok";
    }

    @GetMapping(value = "/api/modify_notification")
    public String modifyNotification(HttpServletRequest request, @RequestParam long id, @RequestParam String name, @RequestParam String description, @RequestParam String date, @RequestParam Boolean repeat, @RequestParam int frequence) throws ParseException {
        logger.info("Modifying");

        Users temp = usersService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Notification> listNotification = temp.getNotifications();

        for (Notification el : listNotification) {
            if(el.getId() == id){
                Notification toReturn = notificationService.findById(id);
                Date dateObj = new SimpleDateFormat("dd/MM/yyyy").parse(date);
                toReturn.setName(name);
                toReturn.setDescription(description);
                toReturn.setDate(dateObj);
                toReturn.setRepeat(repeat);
                toReturn.setFrequence(frequence);
                notificationService.saveAndFlush(toReturn);
                return "DONE";
            }
        }

        return "Nothing to modify";
    }

}