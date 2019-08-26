public class Exercise13 {
    public static void main(String[] args) {
        String[] letters = { "A", "B", "C", "D" };

        for (String letter : letters) {
            if (letter.equals("A")) {
                continue;    // Jump to next iteration
            }

            System.out.println(letter);

            if (letter.equals("C")) {
                break;     // Leave the for loop
            }

        }

    }

}
