package ds.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ButtleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 6, 2, 8};
        System.out.println(Arrays.toString(arr));
        buttleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void buttleSort(int arr[]) {
        //外层控制次数，内层控制比较
        int tmp;
        boolean hasSwap = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if ((tmp = arr[j]) > arr[j + 1]) {
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    hasSwap = false;
                }
            }
            if (hasSwap) {
                return;
            }
        }
    }
}
