package me.guillaume.chuck_facts.adapters.api;

import me.guillaume.chuck_facts.application.UsersService;
import me.guillaume.chuck_facts.infrastructure.persistence.Users;
import me.guillaume.chuck_facts.infrastructure.persistence.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class UsersController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UsersRepository usersService;

    @GetMapping(value = "/api/users")
    public String facts() {
        logger.info("Serving Facts");
        Users temp = usersService.findByEmailAndPassword("flopp@flopp.flopp", "nuclearFLOPP");
        String toReturn = temp.getName();
        return toReturn;
    }

}