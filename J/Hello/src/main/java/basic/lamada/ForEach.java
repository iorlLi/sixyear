package basic.lamada;

public class ForEach extends LamadaData {

    public static void main(String[] args) {
        users.stream().filter(user -> {
            return !user.getAddress().equals("皖");
        }).forEach(user -> {
            System.out.print(user.getName().concat("\t"));
            System.out.print(String.valueOf(user.getAge()).concat("\t"));
            System.out.println(user.getAddress());
            System.out.println("----------------------");
        });
    }
}
