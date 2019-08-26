package com.packtpub.temps;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class City {
    private String name;
    private String country;
    double summertimeHigh;      // In degrees C

    public City(String name, String country, double summertimeHigh) {
        this.name = name;
        this.country = country;
        this.summertimeHigh = summertimeHigh;
    }


    public Element toXml(Document document, Node parent, String tagName) {
        Element city = document.createElement(tagName);

        addChildElement(document, city, "name", name);
        addChildElement(document, city, "country", country);

        String degrees = summertimeHigh + " C";
        addChildElement(document, city, "summertime-high-temp", degrees);

        parent.appendChild(city);
        return city;
    }


    public Element addChildElement(Document document, Node parent, String tagName, String text) {

        Element element = document.createElement(tagName);
        Text textElem = document.createTextNode(text);
        element.appendChild(textElem);
        parent.appendChild(element);

        return element;
    }
}
