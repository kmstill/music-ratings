package com.example.music_ratings.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicRatingController {

    @RequestMapping("/")
    public String getMessage() {
        return "hello this is kevin!!";
    }



}
