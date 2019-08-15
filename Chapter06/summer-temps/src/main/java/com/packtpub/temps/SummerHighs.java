package com.packtpub.temps;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Map;

public class SummerHighs {
    private Table<String, String, SummerHigh> data;

    public SummerHighs() {
        data = HashBasedTable.create();
    }

    public SummerHigh getByCity(String city) {
        Map<String, SummerHigh> row = data.row(city.toLowerCase());

        SummerHigh summerHigh = null;

        for ( String key : row.keySet()) {
            summerHigh = row.get(key);
        }

        return summerHigh;
    }

    public SummerHigh getByCountry(String country) {
        Map<String, SummerHigh> column = data.column(country.toLowerCase());

        SummerHigh summerHigh = null;

        for ( String key : column.keySet()) {
            summerHigh = column.get(key);
        }

        return summerHigh;
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
        City baseCity = summerHigh.getBase();

        data.put(baseCity.getName().toLowerCase(),
                baseCity.getCountry().toLowerCase(), summerHigh);
    }

    public SummerHigh createSummerHigh(City base, City moderateCuts,
                                       City noCuts) {
        return new SummerHigh(base, moderateCuts, noCuts);
    }

    public City createCity(String name, String country, double summertimeHigh) {
        return new City(name, country, summertimeHigh);
    }
}
