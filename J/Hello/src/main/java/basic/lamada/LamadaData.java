package basic.lamada;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LamadaData {

    static List<User> users = userData();

    public static List<User> userData(){
        return new ArrayList<>(Arrays.asList(
                new User(11, "张11", "皖"),
                new User(12, "张12", "皖"),
                new User(21, "李21", "鄂"),
                new User(22, "李22", "鄂"),
                new User(31, "王31", "豫"),
                new User(32, "王32", "豫")
        ));
    }
}

@Data
@AllArgsConstructor
class User{
    private int age;
    private String name;
    private String address;

}