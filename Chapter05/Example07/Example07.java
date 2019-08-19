public class Example07 {
    public static void main(String[] args) {
        // declare a string with nothing inside
        String text = null;

        // you will see this at the console
        System.out.println("Go Java Go!");

        try {
            // null'ed strings should crash your program
            System.out.println(text.length());
        } catch (NullPointerException ex) {
            System.out.println("Exception: cannot get the text's length");
        }

        // you will now see this print
        System.out.println("done");
    }
}
