package com.example.music_ratings;

import com.example.music_ratings.service.SpotifyService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.hc.core5.http.ParseException;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;

import static com.mongodb.client.model.Filters.eq;

@SpringBootApplication
public class MusicRatingsApplication {

	//TODO:  add swagger, add linter

	public static void main(String[] args) throws IOException, ParseException, SpotifyWebApiException {
		SpringApplication.run(MusicRatingsApplication.class, args);

	}


}
