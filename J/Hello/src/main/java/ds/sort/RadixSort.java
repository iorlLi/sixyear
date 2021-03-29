package ds.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{31, 50, 18, 24, 91, 666, 731};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //选出最大的数，用数的位数计算循环次数
        int max = 0;
        for (int a : arr) {
            if (a > max)
                max = a;
        }
        int maxLength = (String.valueOf(max)).length();

        //创建二维数组,用于按照各个位存储
        int[][] r = new int[10][arr.length];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //用于记录每次遍历每个基数数组的元素个数
            int[] index = new int[10];
            //分配
            for (int j = 0; j < arr.length; j++) {
                //计算该位数对应的数组
                int rNum = arr[j] / n % 10;
                //存入rNum对应的数组，下标为计数属组index自增的数
                r[rNum][index[rNum]++] = arr[j];
            }

            int orginArrIndex = 0;
            //取出
            //遍历r
            for (int k = 0; k < r.length; k++) {
                //每个里面有的数位index存的数据
                int[] ints = r[k];
                for (int l = 0; l < index[k]; l++) {
                    arr[orginArrIndex++] = ints[l];
                }
            }
            orginArrIndex = 0;
        }

    }
}
