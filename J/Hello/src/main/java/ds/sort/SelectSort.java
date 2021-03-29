package ds.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {4, 7, 123, 90, 77, 69, 553, 1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择出最小数据的下标
     *
     * @param arr
     */
    static void selectSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;

                }
            }

            //最小数和下标不一致
            if (i != minIndex) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }
}
