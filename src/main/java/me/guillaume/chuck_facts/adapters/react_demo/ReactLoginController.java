package me.guillaume.chuck_facts.adapters.react_demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ReactLoginController {

    @GetMapping("/react/login")
    public String renderMainPage() {
        return new InitialHtml("React Demo").serialize();
    }
}

