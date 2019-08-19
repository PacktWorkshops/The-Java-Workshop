import java.util.*;

public class Example05 {
    public static void main(String[] args) {
        Integer[] myArray = new Integer[] {3, 25, 2, 79, 2};

        Set mySet = new HashSet(Arrays.asList(myArray));

        System.out.println(mySet);
    }
}
