package ds.sort;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 3, 9, 8, 7, 5, 6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 适用于完全二叉树的排序
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //开始位置为最后一个非叶子节点，即最后一个节点的父节点
        int start = (arr.length - 1) / 2;

        //调整为大顶堆
        for (int i = start; i >= 0; i--) {
            maxHeap(arr, arr.length, i);
        }
        System.out.println("构建大顶堆" + Arrays.toString(arr));
        //TODO 大顶堆之后每次最大的总在前面
        //因此将第一个元素调到最后的位置
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            //缩小数据规模
            maxHeap(arr, i, 0);
        }
    }

    /**
     * @param arr
     * @param size  数据容量
     * @param index 最后一个非叶子节点的节点
     */
    public static void maxHeap(int[] arr, int size, int index) {

        int leftNode = 2 * index + 1;
        int rightNode = 2 * index + 2;
        //最大节点下标
        int maxIndex = index;
        int max = arr[index];
        if (leftNode < size && arr[leftNode] > max) {
            maxIndex = leftNode;
            max = arr[maxIndex];
        }
        if (rightNode < size && arr[rightNode] > max) {
            maxIndex = rightNode;
        }

        //交换位置
        if (maxIndex != index) {
            int tmp = arr[maxIndex];
            arr[maxIndex] = arr[index];
            arr[index] = tmp;
            //父节点下沉后，要和自己新的子节点比较
            maxHeap(arr, size, maxIndex);
        }
    }

}
