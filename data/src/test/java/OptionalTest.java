import java.util.Optional;

/**
 * Created by somebody on 2016/8/9.
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("meng1");
        System.out.println(name.isPresent());
        System.out.println(name);
        System.out.println(name.get());
        name.ifPresent((value) -> {
            System.out.println("The length of the value is: " + value.length()+value);
        });

    }
}
