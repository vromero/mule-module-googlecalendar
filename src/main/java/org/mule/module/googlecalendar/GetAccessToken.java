package org.mule.module.googlecalendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.api.client.auth.oauth2.draft10.AccessTokenResponse;
import com.google.api.client.googleapis.auth.oauth2.draft10.GoogleAccessTokenRequest.GoogleAuthorizationCodeGrant;
import com.google.api.client.googleapis.auth.oauth2.draft10.GoogleAuthorizationRequestUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;

public class GetAccessToken {

	private static final String REDIRECT_URL = "urn:ietf:wg:oauth:2.0:oob";
	private static final String SCOPE = "https://www.googleapis.com/auth/calendar";

	HttpTransport httpTransport;
	JacksonFactory jsonFactory;

	public GetAccessToken() {
		httpTransport = new NetHttpTransport();
		jsonFactory = new JacksonFactory();
	}

	private String getAccessToken(String clientId, String clientSecret, String applicationName) throws IOException {
		String authorizationUrl = new GoogleAuthorizationRequestUrl(clientId, REDIRECT_URL, SCOPE).build();

		// Point or redirect your user to the authorizationUrl.
		System.out.println("Go to the following link in your browser:");
		System.out.println(authorizationUrl);

		// Read the authorization code from the standard input stream.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("What is the authorization code?");
		String code = in.readLine();

		AccessTokenResponse response = new GoogleAuthorizationCodeGrant(httpTransport, jsonFactory, clientId, clientSecret, code,
				REDIRECT_URL).execute();

		return response.accessToken;
	}

	public static void main(String[] args) throws IOException {
		String accessToken = new GetAccessToken().getAccessToken("1006517325941.apps.googleusercontent.com", "UG2aa0yyXW7FoSAe0PseSiFt",
				"mule-module-googlecalendar");
		System.out.println(accessToken);
	}

}
