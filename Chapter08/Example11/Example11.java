import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Example11 {
    public static void main(String[] args) {
        String pathString = System.getProperty("user.home") + "/javaTemp/numbers.txt";
        Path pathFile = Paths.get(pathString);

        // if the numbers file doesn't exist, create a file with 10 random numbers
        // between 0 and 10, so that we can make something with them
        if (Files.notExists(pathFile)) {
            int [] numbers = new int[10];
            for (int i = 0; i < 10; i++) {
                numbers[i] = (int) (Math.random() * 10);
            }

            try {
                // create an empty fileReading a Properties File | 321
                Files.createFile(pathFile);
                // write the bytes one by one
                for (int n : numbers) {
                    Files.write(pathFile, Arrays.asList("" + n), StandardOpenOption.APPEND);
                }
            } catch (IOException ioe) {
                System.out.println("WARNING: issue creating random numbers file");
            }
        }

        // once the numbers file exists, we can open it and play around with the data
        try {
            List<String> fileContent = Files.readAllLines(pathFile);
            // this will go through the buffer containing the whole file
            // and print it line by one to System.out
            System.out.println("Raw data");
            fileContent.forEach(System.out::print);
            System.out.println(); // add an EOL

            // this will go through the sorted buffer containing the whole file
            // and print it line by one to System.out
            System.out.println("Sorted data");
            fileContent.stream().sorted().forEach(System.out::print);
            System.out.println(); // add an EOL

            // this will go through the buffer containing the whole file
            // multiply each number by 2 and print it line by one to System.out
            System.out.println("Mapped data");
            fileContent.stream().map( x -> Integer.parseInt(x)*2).forEach(System.out::print);
            System.out.println(); // add an EOL

            // this will go through the buffer containing the whole file
            // make an average and print the result to System.out
            System.out.println("Sum of data");
            System.out.println(
                    fileContent
                            .stream()
                            .map(x -> Integer.parseInt(x))
                            .reduce(Integer::sum));
        } catch (IOException ioe) {
            System.out.println("WARNING: there was an issue with the file");
        }
    }
}
