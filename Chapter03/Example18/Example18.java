/**
* Anonymous class example
* This example shows the declaration of an inner class extending
* an existing class and overriding a method. It can be used as a
* technique to modify an existing method for something more suitable
* to our purpose.
*
* @author Joe Smith
* @version 0.1
* @since 20190305
*/
class Container {
    int c = 17;
    public void print() {
        System.out.println("This is an outer class");
    }
}

public class Example18 {
    public static void main(String[] args) {
        // inner class
        Container container = new Container() {
            @Override
            public void print() {
                System.out.println("This is an inner class");
            }
        };

        container.print();
        System.out.println( container.c );
    }
}
