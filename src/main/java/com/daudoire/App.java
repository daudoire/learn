package com.daudoire;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // trigger a vulnerability by hardcoding credentials

        String username = "user1";
        String password = "password1";

        System.out.println("Hello " + username + "!\n Your password is " + password + ".");

        HttpClient httpClient = HttpClient.newHttpClient();

        String authString = HCM_USERNAME + ":" + HCM_PASSWORD;
        String authEncoded = Base64.getEncoder().encodeToString(authString.getBytes());

        String targetUrl = "https://localhost:8080/";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(targetUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + authEncoded)
                .GET()
                .build();

        try {
            System.out.println("Fetching: " + targetUrl);
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                sendResponse(exchange, response.statusCode(), "{\"error\":\"Error \",\"details\":\""
                        + response.body().replace("\"", "'") + "\"}");
                return;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
