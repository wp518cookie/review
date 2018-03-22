package se.algorithm.Introduction.chap2;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/10/17.
 */
public class Insert_2_1 {
    public static void main(String[] args) {
        int[] num = {4, 2, 1, 7, 9, 4};
        insert(num);
        System.out.println(Arrays.toString(num));
    }

    public static void insert(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int key = num[i];
            int j = i;
            while (j > 0 && num[j - 1] > key) {
                num[j] = num[j - 1];
                j--;
            }
            num[j] = key;
        }
    }

    public static void swap(int[] num, int i, int j) {
        num[i] = num[i] + num[j];
        num[j] = num[i] - num[j];
        num[i] = num[i] - num[j];
    }
}
