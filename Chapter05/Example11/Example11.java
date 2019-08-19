public class Example11 {
    public static void main(String args[]) {
        String text = null;

        try {
            System.out.println(text.length());
        } catch (Exception e) {
            System.out.println("Exception: this should be a NullPointerException");
            throw new RuntimeException();
        }
    }
}
