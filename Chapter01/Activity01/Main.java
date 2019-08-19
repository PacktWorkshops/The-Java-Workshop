public class Main {
    public static void main(String[] args) {
        double a = 3;
        double b = 4;
        double m = 0; // variable for the minimum

        // string to be printed
        String r = "The minimum of numbers: " + a + " and " + b + " is ";

        // mathematical operation
        m = Math.min(a,b);

        System.out.println(r + m); // print out the results
    }
}
