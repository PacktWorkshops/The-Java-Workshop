import java.io.*;
import java.util.concurrent.TimeUnit;

public class Example06 {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;

        try {
            // for Linux / MacOS
            process = runtime.exec(
              "java -cp ../../../../Example05/out/production/Example05:Example05");
            // for Windows
            // process = runtime.exec(
            //   "java -cp ../../../../Example05/out/production/Example05;Example05");
        } catch (IOException ioe) {
                 System.out.println("WARNING: couldn't start your app");
        }

        try {
            process.waitFor(5, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {
            System.out.println("WARNING: interrupted exception fired");
        }

        OutputStream out = process.getOutputStream();
        Writer writer = new OutputStreamWriter(out);
        writer.write("This is how we roll!\n"); // EOL to ensure the process sends back

        writer.flush();
        process.destroy();
    }
}
