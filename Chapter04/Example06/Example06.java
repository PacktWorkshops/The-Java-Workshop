import java.util.*;

public class Example06 {
    public static void main(String[] args) {
        String[] myArray = new String[] {"3", "25", "2", "79", "2"};

        Set mySet = new HashSet();

        Collections.addAll(mySet, myArray);

        System.out.println(mySet);
    }
}
