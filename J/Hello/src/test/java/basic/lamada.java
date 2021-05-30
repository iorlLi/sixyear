package basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class lamada {
    Logger logger = LoggerFactory.getLogger(lamada.class);
    List<User> users = new ArrayList<>(Arrays.asList(
            new User(11, "张11", "皖"),
            new User(12, "张12", "皖"),
            new User(21, "李21", "鄂"),
            new User(22, "李22", "鄂"),
            new User(31, "王31", "豫"),
            new User(32, "王32", "豫")
    ));

    /**
     * collect: 终结操作，汇总作用
     * Collects:提供许多静态收集器
     */
    @Test
    public void test_collect(){
        List<String> collect = users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * reduce: 规约，将元素按照reduce给定的规则汇总计算
     */
    @Test
    public void test_reduce() {
        Integer reduce = users.stream()
                .map(User::getAge)
                .reduce(0, (a, b) -> a + b);
        logger.info("test_reduce  reduce = {}", reduce);

        Optional<Integer> reduce1 = users.stream()
                .map(User::getAge)
                .reduce(Integer::sum);
        System.out.println(reduce1.get());
    }

}

class User {
    private int age;
    private String name;
    private String address;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }
}