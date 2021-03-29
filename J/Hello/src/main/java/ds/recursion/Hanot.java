package ds.recursion;

import javax.xml.bind.SchemaOutputResolver;

/**
 * 汉诺塔
 */
public class Hanot {
    public static void main(String[] args) {
        hanot(5, 'A', 'B', 'C');
        System.out.println(count);
    }

    /**
     * @param n    盘中格式
     * @param from 开始位置
     * @param in   中间位置
     * @param to   目标位置
     */
    private static int count = 0;

    public static void hanot(int n, char from, char in, char to) {
        if (n == 1) {
            System.out.println("将盘子" + n + "从" + from + "移动到" + to);
            count++;
        } else {
            hanot(n - 1, from, to, in);
            System.out.println("将盘子" + n + "从" + from + "移动到" + to);
            count++;
            hanot(n - 1, in, from, to);
        }
    }
}
