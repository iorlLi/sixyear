package ds.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 123, 90, 77, 69, 553, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 以开始元素为基准的快速排序
     * 比基准数大的放在右边，比基准数小的放在左边
     * 因此，右遍历时找小的放在左边low位，
     * 左边遍历找大的放在hight位.
     * 当位置重合时就是基准数的位置。
     * 第一个基准数查询完毕
     * 此时的low位为新的stard位，左右分别递归调用
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //标记高低位
            int low = start, hight = end;
            int stard = arr[start];

            //TODO 以左边数作为基准数就一定要从右边开始比较
            while (low < hight) {
                //右边的数和基准数据比较
                while (low < hight && arr[hight] >= stard) {
                    hight--;
                }
                //右边数替换左边数
                arr[low] = arr[hight];

                while (low < hight && arr[low] <= stard) {
                    low++;
                }
                arr[hight] = arr[low];
            }
            //基准数放在下标重合的地方
            arr[low] = stard;

            //基准数左边的排序
            quickSort(arr, start, low);
            //基准数右边的排序
            quickSort(arr, low + 1, end);
        }
    }
}
