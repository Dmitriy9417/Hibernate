package ru.netology.scloud.cloudconfclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProfileController {

    @Value("${currentProfile}")
    private String currentProfile;

    @GetMapping
    public String getCurrentProfile() {
        return currentProfile;
    }
}
