package com.example.music_ratings.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ParseException;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpotifyService {

    private final SpotifyApi spotifyApi;


    public void callSpotify() throws IOException, ParseException, SpotifyWebApiException {
        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            System.out.println("Expires in: " + clientCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        GetAlbumRequest getAlbumRequest = spotifyApi.getAlbum("6dVIqQ8qmQ5GBnJ9shOYGE")
                .build();
        Album album = getAlbumRequest.execute();
        log.info("Album title: " + album.getName());
        log.info("Tracks: " + album.getTracks());
    }

}
