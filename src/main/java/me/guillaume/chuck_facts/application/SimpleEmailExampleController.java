package me.guillaume.chuck_facts.application;

import me.guillaume.chuck_facts.infrastructure.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class SimpleEmailExampleController {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    UsersRepository usersService;

    @Autowired
    NotificationRepository notificationService;

    @Autowired
    NotificationChannelsRepository notificationChannelsService;

    public void sendEmail(String email, String subject, String text){
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);

        // Send Message!
        this.emailSender.send(message);
    }

    @GetMapping("/sendSimpleEmail")
    public String sendSimpleEmail() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate =  dateFormat.format(new Date());

        String ret = "ok";
        List<Users> listUser = usersService.findAll();
        for(Users temp: listUser){
            List<NotificationChannels> listChannel = temp.getNotificationChannels();
            List<Notification> listNotification = temp.getNotifications();

            for(Notification tempNotif: listNotification){
                for(NotificationChannels tempChannel : listChannel){
                    if(tempNotif.getDate().equals(currentDate)){
                        sendEmail(tempChannel.getDestination(), tempNotif.getName(), tempNotif.getDescription());
                    }
                }
            }
        }

        return currentDate;
    }

}