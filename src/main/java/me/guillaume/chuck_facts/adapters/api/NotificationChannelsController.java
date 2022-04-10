package me.guillaume.chuck_facts.adapters.api;

import me.guillaume.chuck_facts.infrastructure.persistence.NotificationChannels;
import me.guillaume.chuck_facts.infrastructure.persistence.NotificationChannelsRepository;
import me.guillaume.chuck_facts.infrastructure.persistence.Users;
import me.guillaume.chuck_facts.infrastructure.persistence.UsersRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class NotificationChannelsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UsersRepository usersService;

    @Autowired
    NotificationChannelsRepository notificationChannelsService;

    @GetMapping(value = "/api/get_notification_channels")
    public String getNotificationChannels(HttpServletRequest request) {
        logger.info("Getting notification channels");
        Users temp = usersService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<NotificationChannels> toReturn = temp.getNotificationChannels();
        JSONArray json = new JSONArray();
        for (NotificationChannels el : toReturn) {
            JSONObject one = new JSONObject();
            one.put("id", el.getId());
            one.put("name", el.getName());
            one.put("type", el.getType());
            one.put("destination", el.getDestination());
            json.put(one);
        }
        String toReturnString = json.toString();
        return toReturnString;
    }

    @GetMapping(value = "/api/delete_notification_channel")
    public String deleteNotification(HttpServletRequest request, @RequestParam long id) {
        logger.info("Deleting channel");

        Users temp = usersService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<NotificationChannels> toReturn = temp.getNotificationChannels();

        for (NotificationChannels el : toReturn) {
            if(el.getId() == id){
                toReturn.remove(el);
                temp.setNotificationChannels(toReturn);
                usersService.saveAndFlush(temp);
                notificationChannelsService.deleteById(id);
                return "DONE";
            }
        }

        return "Nothing to delete";
    }

    @GetMapping(value = "/api/create_notification_channel")
    public String createNotification(HttpServletRequest request, @RequestParam String name, @RequestParam String type, @RequestParam String destination) throws ParseException {
        logger.info("Creating channel");
        Users temp = usersService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<NotificationChannels> toReturn = temp.getNotificationChannels();

        NotificationChannels newChannel = notificationChannelsService.saveAndFlush(new NotificationChannels(name, type, destination));
        toReturn.add(newChannel);

        temp.setNotificationChannels(toReturn);
        usersService.saveAndFlush(temp);

        // Return new Channel
        JSONObject one = new JSONObject();
        one.put("id", newChannel.getId());
        one.put("name", newChannel.getName());
        one.put("type", newChannel.getType());
        one.put("destination", newChannel.getDestination());
        String toReturnString = one.toString();
        return toReturnString;
    }

    @GetMapping(value = "/api/modify_notification_channel")
    public String modifyNotification(HttpServletRequest request, @RequestParam long id, @RequestParam String name, @RequestParam String type, @RequestParam String destination) throws ParseException {
        logger.info("Modifying");

        Users temp = usersService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<NotificationChannels> listNotificationChannels = temp.getNotificationChannels();

        for (NotificationChannels el : listNotificationChannels) {
            if(el.getId() == id){
                NotificationChannels toReturn = notificationChannelsService.findById(id);
                toReturn.setName(name);
                toReturn.setType(type);
                toReturn.setDestination(destination);
                notificationChannelsService.saveAndFlush(toReturn);
                return "DONE";
            }
        }

        return "Nothing to modify";
    }

}