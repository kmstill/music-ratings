package com.example.music_ratings.model;

import lombok.Data;

import java.util.List;

@Data
public class Album {
    private String title;

    private String artist;

    private int year;

    private List<String> trackList;
}
