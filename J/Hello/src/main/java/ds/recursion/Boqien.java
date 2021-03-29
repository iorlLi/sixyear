package ds.recursion;

public class Boqien {
    public static void main(String[] args) {
        //计算第n个
        // 1 1 2 3 5 8 13
        System.out.println(boqien(7));
    }

    public static int boqien(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return boqien(n - 1) + boqien(n - 2);
        }
    }
}
