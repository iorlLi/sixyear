package ds.serach;

import java.util.Arrays;

public class MaxSub {
    private int o0;

    /**
     * 暴力
     */
    public int maxSub3(int a[]) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int thisSum = 0;
            for (int j = i; j < a.length; j++) {
                thisSum += a[j];
                if (thisSum > max) {
                    max = thisSum;
                }
            }
        }
        return max;
    }

    /**
     * 递归--分治
     * 根据left和right计算出center
     * 分别递归
     * 计算包含center的最大左右子序列求和
     */
    public static int maxSub2(int[] a, int left, int right) {
        /*
         * 这个可不能少呀,循环结束条件
         */
        if (left == right) {
            if (a[left] > 0) {
                return a[left];
            } else {
                return 0;
            }
        }

        int center = (left + right) / 2;
        int maxLeftBranch = maxSub2(a, left, center);
        int maxRightBranch = maxSub2(a, center + 1, right);

        int leftSub = 0, maxLeft = 0;
        for (int i = center; i > left; i--) {
            leftSub += a[i];
            if (leftSub > maxLeft) {
                maxLeft = leftSub;
            }
        }
        int rightSub = 0, maxRight = 0;
        for (int i = center; i < right; i++) {
            rightSub += a[i];
            if (rightSub > maxRight) {
                maxRight = rightSub;
            }
        }
        return max(maxLeftBranch, maxRightBranch, maxLeft + maxRight);
    }

    private static int max(int... a) {
        int max = 0;
        for (int i : a) {
            if (i > max)
                max = i;
        }
        return max;
    }

    /**
     * 负数不会是最大子序列的起点
     * 同理，当子序列为负时，也不会时最大子序列的前缀
     */
    public static int maxSub(int[] a) {
        int max = 0;
        int thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if (thisSum > max) {
                max = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{1, -2, 3, 5, -2, 6, -1};
        int[] arr = new int[]{10, -6, 1, -7, 4, 8, 2};
        int i = maxSub(arr);
        System.out.println(i);
    }
}
