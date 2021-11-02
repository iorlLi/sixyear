package ds;

public class MainTest {
    public static void main(String[] args) {
        int add = add(100);
        System.out.println(add);
    }

    private static int add(int n) {
        if (n == 1) {
            return 1;
        }
        return n + add(n - 1);
    }
}
