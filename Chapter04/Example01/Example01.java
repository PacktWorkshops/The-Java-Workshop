import java.util.Arrays;

public class Example01 {
    public static void main(String[] args) {
        String[] text = new String[] { "spam", "more", "buy" };

        Arrays.sort(text);

        System.out.println(Arrays.toString(text));

        for (int i = 0; i < text.length; i++)
            System.out.print(text[i] + " ");
    }
}
