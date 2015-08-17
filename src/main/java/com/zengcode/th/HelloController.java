package com.zengcode.th;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @Autowired
    private ApplicationConfiguration applicationConfiguration;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot! " + applicationConfiguration.getUsername() + " : " + applicationConfiguration.getServerConfiguration().getDev();
    }



}