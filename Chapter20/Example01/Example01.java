import java.util.Optional;

public class Example01 {
    public static void main(String[] args) {
        // the empty object
        Optional<String> textEmpty = Optional.empty();
        System.out.println("Empty Optional: " + textEmpty);


        // non nullable construction
        Optional<String> textNonNullable = Optional.of("not nullable");
        System.out.println("Non-Empty Optional:" + textNonNullable);

        // nullable construction using a non existing property
        String property = System.getProperty("server.name");
        Optional<String> textNullable = Optional.ofNullable(property);
        System.out.println("ofNullable null Optional: " + textNullable);

        // to force NullPointerException, use the null property on non nullable construction
        Optional<String> textNull = Optional.of(property);
        System.out.println("of null Optional: " + textNull);
    }
}
