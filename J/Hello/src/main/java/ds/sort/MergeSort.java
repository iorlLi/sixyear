package ds.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = new int[]{4, 7, 123, 90, 77, 69, 553, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);
            merge(arr, low, middle, high);
        }
    }

    static void merge(int arr[], int low, int middle, int high) {
        int[] tmp = new int[high - low + 1];
        //middle左边遍历开始下标
        int left = low;
        //middele右边遍历开始下标
        int right = middle + 1;
        //tmp插入下标
        int index = 0;

        // 同时遍历有序放入tmp
        while (left <= middle && right <= high) {
            if (arr[left] <= arr[right]) {
                tmp[index++] = arr[left++];
            } else {
                tmp[index++] = arr[right++];
            }
        }

        //一边全加入到tmp中后，另外的全部加入即可
        while (right <= high) {
            tmp[index++] = arr[right++];
        }
        while (left <= middle) {
            tmp[index++] = arr[left++];
        }

        //数据合并
        for (int k = 0; k < tmp.length; k++) {
            arr[low + k] = tmp[k];
        }
    }
}
