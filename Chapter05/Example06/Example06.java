public class Example06 {
    private static void staticMethod() {
        System.out.println("static method, accessible from null reference");
    }

    private void nonStaticMethod() {
        System.out.print("non-static method, inaccessible from null reference");
    }

    public static void main(String args[]) {
        Example06 object = null;

        object.staticMethod();
        //object.nonStaticMethod();
    }
}
