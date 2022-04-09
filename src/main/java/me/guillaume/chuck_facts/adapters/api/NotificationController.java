package me.guillaume.chuck_facts.adapters.api;

import me.guillaume.chuck_facts.infrastructure.persistence.Notification;
import me.guillaume.chuck_facts.infrastructure.persistence.Users;
import me.guillaume.chuck_facts.infrastructure.persistence.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class NotificationController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UsersRepository usersService;

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping(value = "/api/notification")
    public String facts(HttpServletRequest request) {
        logger.info("Serving Facts");
        Users temp = usersService.findByName(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Notification> toReturn = temp.getNotifications();
        String toReturnString = "";
        for (Notification el : toReturn) {
            toReturnString += "Name --> " + el.getName() + "\nDescription --> " + el.getDescription() + "\nDate --> " + el.getDate() + "\nRepeat --> " + el.getRepeatString() + "\nFrequence --> " + String.valueOf(el.getFrequence()) + "\n\n#####################";
        }
        return toReturnString;
    }

}