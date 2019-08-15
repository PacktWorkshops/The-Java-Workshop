package com.packtpub.temps;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

public class SummerHighs {
    private List<SummerHigh> data = new ArrayList<>();


    public SummerHighs() {
        initialize();
    }


    public void initialize() {

        addSummerHigh(
                createSummerHigh(
                        createCity("London", "United Kingdom", 20.4),
                        createCity("Paris", "France", 22.7),
                        createCity("Milan", "Italy", 25.2)
                )
        );

        addSummerHigh(
                createSummerHigh(
                        createCity("Stockholm", "Sweden", 19.3),
                        createCity("Vilnius", "Lithuania ", 21.7),
                        createCity("Kiev", "Ukraine", 24.2)
                )
        );

        addSummerHigh(
                createSummerHigh(
                        createCity("New York", "US", 27.7),
                        createCity("Belize City", "Belize ", 31.3),
                        createCity("Juarez", "Mexico", 34.4)
                )
        );

        addSummerHigh(
                createSummerHigh(
                        createCity("Tokyo", "Japan", 26.2),
                        createCity("Beijing", "China", 29.0),
                        createCity("Wuhan", "China", 31.2)
                )
        );

        addSummerHigh(
                createSummerHigh(
                        createCity("Barcelona", "Spain", 25.7),
                        createCity("Madrid", "Spain ", 28.9),
                        createCity("Izmir", "Turkey", 32.2)
                )
        );
    }

    // Convenience methods to help initialize data.
    public void addSummerHigh(SummerHigh summerHigh) {
        data.add(summerHigh);
    }

    public SummerHigh createSummerHigh(City base, City moderateCuts, City noCuts) {
        return new SummerHigh(base, moderateCuts, noCuts);
    }

    public City createCity(String name, String country, double summertimeHigh) {
        return new City(name, country, summertimeHigh);
    }

    public void toXml(Document document) {
        Element cities = document.createElement("cities");

        for (SummerHigh summerHigh : data) {
            summerHigh.toXml(document, cities);
        }

        document.appendChild(cities);
    }
}
