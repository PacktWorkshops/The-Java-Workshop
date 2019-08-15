package com.packtpub.temps;

public class Main {
    public static void main(String[] args) {
        // Initialize data
        SummerHighs summerHighs = new SummerHighs();
        summerHighs.initialize();

        boolean fahrenheit = false;

        // Handle inputs
        if (args.length < 2) {
            System.err.println("Error: usage is:");
            System.err.println(" -city London");
            System.err.println(" -country United Kingdom");
            System.exit(-1);
        }

        String searchBy = args[0];
        String name = args[1];

        SummerHigh high = null;

        if ("-city".equals(searchBy)) {
            high = summerHighs.getByCity(name);
        } else if ("-country".equals(searchBy)) {
            high = summerHighs.getByCountry(name);
        }


        // Activity 2
        if (args.length > 2) {
            if ("-f".equals(args[2])) {
                fahrenheit = true;
            }
        }

        // Output data
        if (high != null) {
            System.out.println( high.format(fahrenheit) );
        } else {
            System.out.println(name + " was not found");
        }
    }
}
