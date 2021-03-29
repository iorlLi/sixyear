package ds.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {4, 7, 123, 90, 77, 69, 553, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(loopCount);
    }

    static int loopCount = 0;

    /**
     * 待排序下标左边都是有序的
     * ①下标插入
     * ②找到之后直接交换位置
     */
    static void insertSort(int[] arr) {
        //从第二个开始向前比较
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int index = i;
            if (tmp < arr[i - 1]) {//插入排序时，开始的位置之前都已经是有序的了
                for (int j = i - 1; j >= 0; j--) {
                    if (tmp < arr[j]) {
                        arr[j + 1] = arr[j];
                        index = j;
                    }
                }
                arr[index] = tmp;
            }
            /*for (int j = i; j > 0; j--) {
                loopCount++;
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                } else {
                    break;
                }

            }*/

        }
    }
}
