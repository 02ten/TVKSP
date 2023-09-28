package com.example.application.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class PhotoController {
    @GetMapping("/photo")
    public ResponseEntity<byte[]> getImage() throws IOException {
        InputStream in = getClass().getResourceAsStream("/photo.png");
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(in.readAllBytes());
    }
}
