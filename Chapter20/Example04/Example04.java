import java.util.Optional;

public class Example04 {
    public static class MyVeryOwnException extends Exception {
        // you should have some more stuff in here
    }

    public static void main(String[] args) throws MyVeryOwnException {
        // non nullable construction
        Optional<String> textNonNullable = Optional.of("not nullable");
        String textNonNullableSafe = textNonNullable.orElse("this is empty");
        System.out.println("Non-Empty Optional:" + textNonNullableSafe);

        // the empty object
        Optional<String> textEmpty = Optional.empty();
        String textEmptySafe = textEmpty.orElseThrow(
            () -> { return new MyVeryOwnException(); }
        );

        System.out.println("Empty Optional: " + textEmptySafe);
    }
}
