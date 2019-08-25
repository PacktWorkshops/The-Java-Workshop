import java.util.*;

public class Example12 {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(35);
        list.add(19);
        list.add(11);
        list.add(83);
        list.add(7);

        System.out.println(list);
        int index = list.indexOf(19);
        System.out.println("Find 19 at: " + index);

        System.out.println("Component: " + list.get(index));
    }
}
