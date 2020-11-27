import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Example10 {
    public static void main(String[] args) throws IOException {
        // declare a list that will contain all of the lines
        // inside of the readme.txt file
        List<String> lines = Collections.emptyList();

        try {
            // provoke an exception
            lines = Files.readAllLines(Paths.get("readme.txt"));
        } catch (NoSuchFileException fe) {
            System.out.println("Exception: File Not Found");
            //fe.printStackTrace();
        }

        // after catching the exception, this code is executed
        Iterator<String> iterator = lines.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
