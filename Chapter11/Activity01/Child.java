import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import static java.lang.Thread.sleep;

public class Child {

    public static void main(String[] args) throws java.io.IOException, InterruptedException {
        int ch;
        System.out.print ("Let's echo: ");

        // echo out whatever comes from system in
        while ((ch = System.in.read ()) != '\n')
            System.out.print ((char) ch);

        // the Child process will be logged in a file here
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(new File("mycal2022.txt")));

        int cont = 0;
        while(cont <= 50) {
            System.out.println(cont++);

            // add this to loop the counting (useful for testing)
            //cont %= 50;

            // added this to log data in local file + EOL
            bufferedWriter.write(cont + "\n");
            bufferedWriter.flush();

            sleep(1000);

            if (System.in.available() > 0) {
                ch = System.in.read();

                // reset counter if asterisk
                if (ch == '*') {
                    cont = 0;
                }
            }
        }
        bufferedWriter.close();
    }
}
