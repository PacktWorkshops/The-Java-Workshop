import java.io.*;
import java.util.concurrent.TimeUnit;

public class Example07 {
     public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;

        try {
            // for Linux / MacOS
            process = runtime.exec(
                "java -cp ../../../../Example05/out/production/Example05:Example05");
            // for Windows
            // process = runtime.exec(
            //      "java -cp ../../../../Example05/out/production/Example05;Example05");
        } catch (IOException ioe) {
            System.out.println("WARNING: couldn't start your app");
        }

        try {
            process.waitFor(5, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {400 | Processes
            System.out.println("WARNING: interrupted exception fired");
        }

        // write to the child's System.in
        OutputStream out = process.getOutputStream();
        Writer writer = new OutputStreamWriter(out);
        writer.write("This is how we roll!\n");
        writer.flush();

        // prepare the data logger
        File file = new File("data.log");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // read from System.out from the child
        InputStream in = process.getInputStream();
        Reader reader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();

        // send to screen
        System.out.println(line);

        // send to file
        bufferedWriter.write(line);
        bufferedWriter.flush();
        process.destroy();
    }
}
