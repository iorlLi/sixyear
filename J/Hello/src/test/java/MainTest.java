import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MainTest {

    @Test
    public void test2() {
        short a = 1;
//        a = a + 1;
        a += 6666;
        System.out.println(a);
    }

    @Test
    public void test1() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);

        BiPredicate<String, String> biPredicate1 = String::equals;
        boolean test = biPredicate.test("a", "a");

        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("aaa");
        consumer = System.out::println;
        consumer.accept("bbb");


        Supplier<String> stringSupplier = () -> Math.random() * 100 + "";
        String s = stringSupplier.get();
        System.out.println(s);

        Function<String, Integer> function = s1 -> Integer.valueOf(s1);
        Integer apply = function.apply("500");
        function = Integer::valueOf;
        Integer apply1 = function.apply("100");
        System.out.println(apply);
        System.out.println(apply1);

    }
}
