package com.packtpub.temps;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SummerHigh {
    private City base;
    private City moderateCuts;
    private City noCuts;


    public SummerHigh(City base, City moderateCuts, City noCuts) {
        this.base = base;
        this.moderateCuts = moderateCuts;
        this.noCuts = noCuts;
    }

    public void toXml(Document document, Node parent) {
        Element city = base.toXml(document, parent, "city");

        Element in2100 = document.createElement("in-year-2100");
        city.appendChild(in2100);

        moderateCuts.toXml(document, in2100, "with-moderate-emission-cuts");
        noCuts.toXml(document, in2100, "with-no-emission-cuts");

        parent.appendChild(city);
    }
}
