import java.util.Arrays;

public class Activity1 {
    public static void main(String[] args) {
        String[] text = {"So", "many", "books", "so", "little", "time"};
        String searchQuery = "so";
        int occurrence = -1;

        for(int i = 0; i < text.length; i++) {
            occurrence = text[i].compareToIgnoreCase(searchQuery);
            if (occurrence == 0) {
                System.out.println("Found query at :" + i);
            }
        }

/* Alternative solution displaying the total amount of findings at the end
        for(int i = 0; i < text.length; i++) {
            if (text[i].compareToIgnoreCase(searchQuery) == 0) {
                System.out.println("Found query at :" + i);
                occurrence++;
            }
        }

        if (occurrence > -1) {
            occurrence++;
            System.out.println("Found: " + occurrence + " coinciding words");
        }
*/
    }
}
