package ds.serach;

/**
 * 最大公约数
 */
public class Gcd {
    public static void main(String[] args) {
        gcd(1989, 1590);
    }

    private static void gcd(long m, long n) {
        System.out.print("输入： " + m + "| " + n + ", 最大公约数为: ");
        while (n != 0) {
            long rem = m % n;
            m = n;
            n = rem;
        }
        System.out.println(m);
    }
}
