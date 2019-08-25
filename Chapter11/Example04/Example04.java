import java.io.IOException;

public class Example04 {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("firefox");
        Process process = null;

        try {
            process = processBuilder.start();
        } catch (IOException ioe) {
            System.out.println("WARNING: something happened with exec");
        }

        try {
            process.waitFor(10, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {
            System.out.println("WARNING: interruption happened");
        }

        process.destroy();
    }
}
