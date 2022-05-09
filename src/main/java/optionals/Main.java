package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable("Hello")
                .orElseGet(() -> "default value");
        System.out.println(value + "\n");

        Supplier<IllegalStateException> exception =
                () -> new IllegalStateException("exception");
        Object value2 = Optional.ofNullable("Hello")
                .orElseThrow(exception);
        System.out.println(value2 + "\n");

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email ->
                        System.out.println("Sending email to " + email + "\n"));

        Optional.ofNullable(null)
                .ifPresentOrElse(email ->
                        System.out.println("Sending email to " + email),
                        () -> {
                            System.out.println("Cannot send email");
                        });
    }
}
