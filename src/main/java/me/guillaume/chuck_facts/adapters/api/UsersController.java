package me.guillaume.chuck_facts.adapters.api;

import me.guillaume.chuck_facts.application.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class UsersController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping(value = "/api/users")
    public List<String> facts() {
        logger.info("Serving Facts");
        List<String> toReturn =
                usersService.users()
                .stream()
                .map(p -> String.valueOf(p.getName()))
                .collect(toList());
        return toReturn;
    }

}