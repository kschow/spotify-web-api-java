package com.wrapper.spotify.requests.authorization.authorization_code;

import com.wrapper.spotify.ITest;
import com.wrapper.spotify.TestUtil;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class AuthorizationCodeRequestTest implements ITest<AuthorizationCodeCredentials> {

  private final AuthorizationCodeRequest successRequest = SPOTIFY_API.authorizationCode("Code")
          .setHttpManager(
                  TestUtil.MockedHttpManager.returningJson(
                          "requests/authorization/authorization_code/AuthorizationCode.json"))
          .build();

  public AuthorizationCodeRequestTest() throws Exception {
  }

  @Test
  public void shouldSucceed_sync() throws IOException, SpotifyWebApiException {
    shouldSucceed(successRequest.execute());
  }

  @Test
  public void shouldSucceed_async() throws ExecutionException, InterruptedException {
    shouldSucceed((AuthorizationCodeCredentials) successRequest.executeAsync().get());
  }

  public void shouldSucceed(final AuthorizationCodeCredentials authorizationCodeCredentials) {
    assertEquals(
            "NgCXRK...MzYjw",
            authorizationCodeCredentials.getAccessToken());
    assertEquals(
            "Bearer",
            authorizationCodeCredentials.getTokenType());
    assertEquals(
            "user-read-private user-read-email",
            authorizationCodeCredentials.getScope());
    assertEquals(
            3600,
            (int) authorizationCodeCredentials.getExpiresIn());
    assertEquals(
            "NgAagA...Um_SHo",
            authorizationCodeCredentials.getRefreshToken());
  }
}