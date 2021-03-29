package ds.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int arr[] = new int[]{4, 7, 123, 90, 77, 69, 553, 1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void shellSort(int[] arr) {
        //步距
        for (int d = arr.length / 2; d > 0; d /= 2) {
            for (int i = d; i < arr.length; i++) {

                //和i之前所有步距的比较
                for (int j = i - d; j >= 0; j -= d) {
                    if (arr[j] > arr[j + d]) {
                        int tmp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = tmp;
                    }
                }
            }
        }
    }
}
