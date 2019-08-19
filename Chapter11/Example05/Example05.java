public class Example05 {
    public static void main(String[] args) throws java.io.IOException
    {
        int c;

        System.out.print ("Let's echo: ");

        while ((c = System.in.read ()) != '\n')
            System.out.print ((char) c);
    }
}
