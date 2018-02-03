package algorithm.Introduction.chap2;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/1/8.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {14, 12 ,3, 4, 1, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int length = arr.length;
        for (int i = arr.length >>> 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, length);
        }
        for (int i = 0; i < length; i++) {
            swap(arr, 0, length - i - 1);
            adjustHeap(arr, 0, length - i - 1);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (temp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
            arr[i] = temp;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}
