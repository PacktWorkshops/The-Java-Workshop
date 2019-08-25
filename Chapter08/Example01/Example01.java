import java.io.*;
import java.util.*;

public class Example01 {
    public static void main(String[] args) throws IOException {
        String pathString = System.getProperty("java.io.tmpdir");

        String [] fileNames = new File(pathString).list();

        for (int i = 0; i < 5; i++ ) {
            System.out.println(fileNames[i]);
        }
    }
}
