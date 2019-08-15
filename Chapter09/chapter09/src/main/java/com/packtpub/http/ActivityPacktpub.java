package com.packtpub.http;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ActivityPacktpub {
    public static void main(String[] args) {

        try {
            Document doc =
                    Jsoup.connect("https://www.packtpub.com/tech/Java").get();

            Elements titles = doc.select("div.book-block-title");

            for (Element div : titles) {
                System.out.println(div.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
