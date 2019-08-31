import java.io.*;
import java.util.concurrent.TimeUnit;

public class Parent {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;

        try {
            // for Linux / MacOS
            process = runtime.exec("java -cp ../../../../Child/out/production/Child: Child");
            // for Windows
            // process = runtime.exec("java -cp ../../../../Child/out/production/Child; Child");
        } catch (IOException ioe) {
            System.out.println("WARNING: couldn't start your app");
        }

        try {
            process.waitFor(5, TimeUnit.SECONDS);
        } catch (InterruptedException ie) {
            System.out.println("WARNING: interrupted exception fired");
        }

        System.out.println("trying to write");
        OutputStream out = process.getOutputStream();
        Writer writer = new OutputStreamWriter(out);
        writer.write("This is how we roll!\n");
        writer.flush();

        File file = new File("data.log");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        System.out.println("trying to read");
        InputStream in = process.getInputStream();
        Reader reader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();

        // send to screen
        System.out.println(line);

        // send to file
        bufferedWriter.write(line);
        bufferedWriter.flush();

        while (line != null) {
            // send to screen
            System.out.println(line);

            // send to file + EOL
            bufferedWriter.write(line  + "\n");
            bufferedWriter.flush();

            // read next line
            line = bufferedReader.readLine();

            // this will force the reset of the counter
            // the program will therefore never end
            if (Integer.parseInt(line) == 37) {
                writer.write('*');
                writer.flush(); // needed because of the buffered output
                System.out.println("sent message");
            }
        }
        process.destroy();
    }
}
