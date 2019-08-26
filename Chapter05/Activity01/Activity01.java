import java.nio.file.NoSuchFileException;
import java.util.logging.*;

public class Activity01 {

    public static void issuePointerException() throws NullPointerException {
        throw new NullPointerException("Exception: file not found");
    }

    public static void issueFileException() throws NoSuchFileException {
        throw new NoSuchFileException("Exception: file not found");
    }

    public static void main(String[] args) throws NullPointerException, NoSuchFileException {
        Logger logger = Logger.getAnonymousLogger();

        // int exceptionNum = 2; // for testing
        int exceptionNum = Integer.valueOf(args[0]);


        switch (exceptionNum) {
            case 1:
                try {
                    issuePointerException();
                } catch (NullPointerException ne) {
                    logger.log(Level.SEVERE, "Exception happened", ne);
                }
                break;
            case 2:
                try {
                    issueFileException();
                } catch (NullPointerException ne) {
                    logger.log(Level.WARNING, "Exception happened", ne);
                }
                break;
            case 3:
                try {
                    issueFileException();
                } catch (NullPointerException ne) {
                    logger.log(Level.INFO, "Exception happened", ne);
                }
                break;
        }
    }
}
