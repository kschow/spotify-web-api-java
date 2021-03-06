package data.player;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.player.SeekToPositionInCurrentlyPlayingTrackRequest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class SeekToPositionInCurrentlyPlayingTrackExample {
  private static final String accessToken = "taHZ2SdB-bPA3FsK3D7ZN5npZS47cMy-IEySVEGttOhXmqaVAIo0ESvTCLjLBifhHOHOIuhFUKPW1WMDP7w6dj3MAZdWT8CLI2MkZaXbYLTeoDvXesf2eeiLYPBGdx8tIwQJKgV8XdnzH_DONk";
  private static final int positionMs = 10000;

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
          .setAccessToken(accessToken)
          .build();
  private static final SeekToPositionInCurrentlyPlayingTrackRequest seekToPositionInCurrentlyPlayingTrackRequest =
          spotifyApi.seekToPositionInCurrentlyPlayingTrack(positionMs)
                  .device_id("5fbb3ba6aa454b5534c4ba43a8c7e8e45a63ad0e")
                  .build();

  public static void seekToPositionInCurrentlyPlayingTrack_Sync() {
    try {
      final String string = seekToPositionInCurrentlyPlayingTrackRequest.execute();

      System.out.println("Empty String: " + string);
    } catch (IOException | SpotifyWebApiException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void seekToPositionInCurrentlyPlayingTrack_Async() {
    try {
      final Future<String> stringFuture = seekToPositionInCurrentlyPlayingTrackRequest.executeAsync();

      // ...

      final String string = stringFuture.get();

      System.out.println("Empty String: " + string);
    } catch (InterruptedException | ExecutionException e) {
      System.out.println("Error: " + e.getCause().getMessage());
    }
  }
}