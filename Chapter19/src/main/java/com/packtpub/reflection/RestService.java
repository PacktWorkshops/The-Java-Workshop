package com.packtpub.reflection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestService {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIssPositionAsString() {
        StringBuilder buffer = new StringBuilder();

        try {
            URL url = new URL(path);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            while ((line = in.readLine()) != null) {
                buffer.append(line);
                buffer.append("\n");
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }

    public IssPosition getIssPosition() {
        IssPosition position = null;

        String json = getIssPositionAsString();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            position = objectMapper.readValue(json, IssPosition.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return position;
    }

    public static void main(String[] args) {
        RestService restService = new RestService();
        restService.setPath("http://api.open-notify.org/iss-now.json");

        // Get JSON as object.
        IssPosition position = restService.getIssPosition();
        System.out.println(position);

        // Convert back to JSON.
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(position);

            System.out.println("As JSON:\n" + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
