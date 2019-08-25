import java.util.*;

public class Example11 {
    public static void main(String[] args) {
        Set set1 = new LinkedHashSet();

        set1.add(35);
        set1.add(19);
        set1.add(11);
        set1.add(83);
        set1.add(7);

        Set set2 = new LinkedHashSet();

        set2.add(3);
        set2.add(19);
        set2.add(11);
        set2.add(0);
        set2.add(7);

        set1.removeAll(set2);

        System.out.println(set1);
    }
}
