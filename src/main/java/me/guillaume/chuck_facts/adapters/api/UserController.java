package me.guillaume.chuck_facts.adapters.api;

import me.guillaume.chuck_facts.application.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/api/user")
    public List<String> facts() {
        logger.info("Serving Facts");
        List<String> toReturn =
                userService.users()
                .stream()
                .map(p -> String.valueOf(p.getName()))
                .collect(toList());
        return toReturn;
    }

}