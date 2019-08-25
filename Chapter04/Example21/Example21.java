import java.util.*;

public class Example21 {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.put("OS", "Ubuntu Linux");
        properties.put("version", "18.04");
        properties.put("language", "English (UK)");

        properties.list(System.out);
    }
}
