import java.util.Optional;

public class Example05 {
    public static class MyVeryOwnException extends Exception {
        // you should have some more stuff in here
    }

    public static void main(String[] args) throws MyVeryOwnException {
        // non nullable construction
        Optional<String> textNonNullable = Optional.of("not nullable");
        if (textNonNullable.isPresent()) {
            System.out.println("Non-Empty Optional:" + textNonNullable.
get());
        }

        // the empty object
        Optional<String> textEmpty = Optional.empty();
        if (textEmpty.isEmpty()) {
            System.out.println("this object is empty");
        } else {
            System.out.println("Empty Optional: " + textEmpty.get());
        }
    }
}
