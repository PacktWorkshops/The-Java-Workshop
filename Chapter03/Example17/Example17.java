class Container {
    int c = 17;
    public void print() {
        System.out.println("This is an outer class");
    }
}

class Example17 {
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
