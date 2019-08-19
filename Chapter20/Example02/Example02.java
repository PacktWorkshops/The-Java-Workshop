import java.util.Optional;

public class Example02 {
    public static void main(String[] args) {
        // non nullable construction
        Optional<String> textNonNullable = Optional.of("not nullable");
        System.out.println("Non-Empty Optional:" + textNonNullable.get());

        // the empty object
        Optional<String> textEmpty = Optional.empty();
        System.out.println("Empty Optional: " + textEmpty.get());
    }
}
