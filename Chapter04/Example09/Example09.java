import java.util.*;

public class Example09 {
    public static void main(String[] args) {
        Integer[] numbers1 = new Integer[] {3, 25, 2, 79, 2};
        Integer[] numbers2 = new Integer[] {7, 12, 14, 79};

        Set<Integer> set1 = new TreeSet<>();
        Collections.addAll(set1, numbers1);

        Set<Integer> set2 = new TreeSet<>();
        Collections.addAll(set2, numbers2);

        set1.retainAll(set2);

        System.out.println(set1);
    }
}
