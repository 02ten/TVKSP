package com.example.application.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhotoController {
    @GetMapping("/photo")
    public String getPhoto(){
        return "photo";
    }
}
