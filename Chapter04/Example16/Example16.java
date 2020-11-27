import java.util.*;

public class Example16 {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();

        array.add(5);
        array.add(2);
        array.add(37);

        Iterator<Integer> iterator = array.iterator();

        while (iterator.hasNext()) {
	        // point to next element
	        int i = iterator.next();
	        // print elements
	        System.out.print(i + " ");
        }
    }
}
