package com.example.music_ratings.config;

import com.example.music_ratings.service.MongoService;
import com.example.music_ratings.service.SpotifyService;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

import java.io.IOException;

@Configuration
@Slf4j
public class AppConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spotify.client.id}")
    private static String spotifyClientId;

    @Value("${spotify.client.secret}")
    private static String spotifyClientSecret;

    @Bean
    public MongoClient getMongoClient(){
        return MongoClients.create(mongoUri);
    }

    @Bean
    public MongoService getMongoService(final MongoClient mongoClient){
        return new MongoService(mongoClient);
    }

    @Bean
    public SpotifyApi getSpotifyApi(){
        final SpotifyApi spotifyApi = new SpotifyApi.Builder()
                .setClientId(spotifyClientId)
                .setClientSecret(spotifyClientSecret)
                .build();

        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            log.info("SpotifyApi access expires in: {}", clientCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            log.error("Error getting credentials for spotifyApi: {}", e.getMessage());
        }
        return spotifyApi;
    }

    @Bean
    public SpotifyService getSpotifyService(final SpotifyApi spotifyApi){
        return new SpotifyService(spotifyApi);
    }
}


