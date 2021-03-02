package basic.jvm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@AllArgsConstructor
@ToString
class User {
    private String name;
    private int age;

}

/**
 * 原子引用
 */
public class AtomaticReferenceDemo {
    public static void main(String[] args) {
        User u1 = new User("a", 1);
        User u2 = new User("b", 2);
        AtomicReference<User> ref = new AtomicReference<User>();
        ref.set(u1);
        System.out.println(ref.compareAndSet(u1, u2) + "\t" + ref.get().toString());

    }

}


