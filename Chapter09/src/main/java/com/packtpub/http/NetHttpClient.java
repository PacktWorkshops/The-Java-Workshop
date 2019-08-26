package com.packtpub.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class NetHttpClient {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(30))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://example.com/"))
                .timeout(Duration.ofSeconds(30))
                .header("Accept", "text/html")
                .build();
        HttpResponse<String> response = null;

        try {
            response =
                    client.send(request,
                            HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Code: " + response.statusCode());
        System.out.println(response.body());
    }
}
