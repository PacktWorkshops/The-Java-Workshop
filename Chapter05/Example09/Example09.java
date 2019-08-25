import java.io.*;•
import java.nio.file.*;
import java.util.*;

public class Example09 {
    public static void main(String[] args) {
        // declare a list that will contain all of the files
        // inside of the readme.txt file
        List<String> lines = Collections.emptyList();

        try {
            // provoke an exception
            lines = Files.readAllLines(Paths.get("readme.txt"));
        } catch (NullPointerException|IOException ex) {
            System.out.println("Exception: File Not Found or NullPointer");
            ex.printStackTrace();
        }

        // you will never see this print
        Iterator<String> iterator = lines.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
