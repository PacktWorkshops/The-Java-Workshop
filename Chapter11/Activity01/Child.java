import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import static java.lang.Thread.sleep;

public class Child {

    public static void main(String[] args) throws java.io.IOException, InterruptedException {
        int ch;
        System.out.print ("Let's echo: ");
        while ((ch = System.in.read ()) != '\n')
            System.out.print ((char) ch);
        BufferedWriter bw=new BufferedWriter(
                new FileWriter(new File("mycal2022.txt")));
            int cont = 0;
            while(cont < 49) {
                System.out.println(cont++);
                cont %= 50;
                bw.write(cont + "\n");

                sleep(200);

                if (System.in.available() > 0) {
                    ch = System.in.read();
                    if (ch == '*') {
                        cont = 0;
                    }
                }
            }
        bw.close();
    }
}
