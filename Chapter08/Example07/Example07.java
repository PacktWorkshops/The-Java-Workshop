import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Example07 {
    public static void main(String[] args) {
        String pathString = System.getProperty("user.home") + "/javaTemp/temp.txt";
        Path pathFile = Paths.get(pathString);
        String text = "Hola,\nme da un refresco,\npor favor?";

        if(Files.exists(pathFile))
            try {
                Files.write(pathFile, Arrays.asList(text), StandardOpenOption.APPEND);
                System.out.println("Text added to the file: " + pathFile);
            } catch (IOException ioe) {
                System.out.println("EXCEPTION: " + ioe.getMessage());
            }
    }
}
