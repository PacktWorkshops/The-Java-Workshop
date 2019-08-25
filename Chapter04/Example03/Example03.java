import java.util.Arrays;

public class Example03 {
    public static void main(String[] args) {
        int[] numbers1 = new int[3];
        Arrays.fill(numbers1, 1);

        int[] numbers2 = {0, 0, 0};
        boolean comparison = Arrays.equals(numbers1, numbers2);
        System.out.println(comparison);

        int[] numbers3 = {1, 1, 1};
        comparison = Arrays.equals(numbers1, numbers3);
        System.out.println(comparison);

        int[] numbers4 = {1, 1};
        comparison = Arrays.equals(numbers1, numbers4);
        System.out.println(comparison);
    }
}
