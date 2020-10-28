import java.util.Arrays;

public class Activity01 {
    public static void main(String[] args) {
        String[] text = {"So", "many", "books", "so", "little", "time"};
        String toSearch = "so";
        int occurrences = -1;

        for(int i = 0; i < 5; i++) {
            if (text[i].compareToIgnoreCase(toSearch) == 0) {
                System.out.println("Found query at :" + i);
                occurrences++;
            } 
        }

        if (occurrences > -1) {
            occurrences++;
            System.out.println("Found: " + occurrences + " coinciding words");
        }
    }
}
