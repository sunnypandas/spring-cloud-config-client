package me.panpan.config.client.controller;

import me.panpan.config.client.service.SpringCloudConfigClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringCloudConfigClientController {

    @Autowired
    private SpringCloudConfigClientService service;

    @GetMapping("/config")
    public String getConfig() {
        return "Role: " + service.getRole();
    }
}
