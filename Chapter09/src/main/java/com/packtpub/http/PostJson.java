package com.packtpub.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PostJson {
    public static void main(String[] args) {
        /*
        {
            "animal": "dog",
            "name": "biff"
        }
         */
        String content = "{ \"animal\": \"dog\", \"name\": \"biff\" }";

        String path = "http://httpbin.org/post";

        try {
            URL url = new URL(path);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/json");
            connection.setDoOutput(true);

            DataOutputStream out =
                    new DataOutputStream( connection.getOutputStream() );
            out.writeBytes(content);
            out.flush();
            out.close();

            int responseCode = connection.getResponseCode();
            System.out.println("Code: " + responseCode);
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Got an unexpected response code");
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
