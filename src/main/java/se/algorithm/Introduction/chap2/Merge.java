package se.algorithm.Introduction.chap2;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/10/18.
 * 归并排序
 */
public class Merge {
    public static void main(String[] args) {
        int[] num = {1, 8 , 1, 5, 2, 4, 3};
        sort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void sort(int[] num) {
        int n = num.length;
        sort(num, 0, num.length - 1);
    }

    public static void sort(int[] num, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        sort(num, low, mid);
        sort(num, mid + 1, high);
        merge(num, low, mid, high);
    }

    public static void merge(int[] num, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int[] temp = new int[num.length];
        int tmp = low;
        int index = low;
        while (i <= mid && j <= high) {
            if (num[i] < num[j]) {
                temp[index++] = num[i++];
            } else {
                temp[index++] = num[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = num[i++];
        }
        while (j <= high) {
            temp[index++] = num[j++];
        }
        while (tmp <= high) {
            num[tmp] = temp[tmp++];
        }
    }
}
