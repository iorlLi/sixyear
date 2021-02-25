package sc;

public class MainTest {
    public static void main(String[] args) {
        // 0000 1000  0000 0010
        int a = 10, b = 2;
        System.out.println(a ^ b);//00001010
        System.out.println(a | b);//00001010
        System.out.println(a & b);//00000000
    }
}
