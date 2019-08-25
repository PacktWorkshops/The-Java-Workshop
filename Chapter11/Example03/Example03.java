import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Example03 {
     public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;

        try {
            process = runtime.exec("firefox");
         } catch (IOException ioe) {
            System.out.println("WARNING: something happened with exec");
        }

        try {
            process.waitFor(5, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {
            System.out.println("WARNING: interruption happened");
        }

        process.destroy();
    }
}
