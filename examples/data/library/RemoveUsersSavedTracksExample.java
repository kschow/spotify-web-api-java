package data.library;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.library.RemoveUsersSavedTracksRequest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class RemoveUsersSavedTracksExample {
  private static final String accessToken = "taHZ2SdB-bPA3FsK3D7ZN5npZS47cMy-IEySVEGttOhXmqaVAIo0ESvTCLjLBifhHOHOIuhFUKPW1WMDP7w6dj3MAZdWT8CLI2MkZaXbYLTeoDvXesf2eeiLYPBGdx8tIwQJKgV8XdnzH_DONk";
  private static final String[] ids = new String[]{"01iyCAUm8EvOFqVWYJ3dVX"};

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setAccessToken(accessToken)
          .build();
  private static final RemoveUsersSavedTracksRequest removeUsersSavedTracksRequest = spotifyApi
          .removeUsersSavedTracks(ids)
          .build();

  public static void removeUsersSavedTracks_Sync() {
    try {
      final String string = removeUsersSavedTracksRequest.execute();

      System.out.println("Empty string: " + string);
    } catch (IOException | SpotifyWebApiException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void removeUsersSavedTracks_Async() {
    try {
      final Future<String> stringFuture = removeUsersSavedTracksRequest.executeAsync();

      // ...

      final String string = stringFuture.get();

      System.out.println("Empty string: " + string);
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("Error: " + e.getCause().getMessage());
    }
  }
}