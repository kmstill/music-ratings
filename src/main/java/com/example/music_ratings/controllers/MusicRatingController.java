package com.example.music_ratings.controllers;
import com.example.music_ratings.service.MongoService;
import com.example.music_ratings.service.SpotifyService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MusicRatingController {

    private MongoService mongoService;

    private SpotifyService spotifyService;


    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @RequestMapping("/hello")
    public String getMessage() {
        return "hello this is bkd!";
    }

    @RequestMapping("/doSomething")
    public void doSomething(){

    }
}
