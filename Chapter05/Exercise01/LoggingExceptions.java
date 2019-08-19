import java.util.logging.*;

public class LoggingExceptions {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        String s = null;

        try {
            System.out.println(s.length());
        } catch (NullPointerException ne) {
            logger.log(Level.SEVERE, "Exception happened", ne);
        }
    }
}
