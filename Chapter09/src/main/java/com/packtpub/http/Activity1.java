package com.packtpub.http;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Activity1 {

    public static void main(String[] args) {

        try {
            String url = "http://hc.apache.org/";

            Document doc =
                    Jsoup.connect(url).get();

            Elements sections = doc.select("div.section");

            for (Element div : sections) {

                for (Element child : div.children()) {
                    String tag = child.tagName();
                    if (tag.equalsIgnoreCase("h3")) {

                        Elements links = child.getElementsByTag("a");
                        for (Element link : links) {
                            System.out.println(link.text());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
