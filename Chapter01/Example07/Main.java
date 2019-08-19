public class Main {
    public static void main(String[] args) {
        double a = 3; // first side of the triangle
        double b = 4; // second side of the triangle
        double h = 0; // hypotenuse, init with value 0

        // equation to solve the hypotenuse
        h = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));

        System.out.println(h); // print out the results
    }
}
