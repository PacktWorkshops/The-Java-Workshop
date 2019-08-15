package com.packtpub.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HeadRequest {
    public static void main(String[] args) {
        String path = "http://example.com";

        try {
            URL url = new URL(path);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("HEAD");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = connection.getResponseCode();
            System.out.println("Code: " + responseCode);
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Got an unexpected response code");
            }
            System.out.println( connection.getResponseMessage() );

            // Returned HTTP headers.
            Map<String, List<String>> headers =
                    connection.getHeaderFields();

            for (String key : headers.keySet()) {
                System.out.println(key + ": " + headers.get(key));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
