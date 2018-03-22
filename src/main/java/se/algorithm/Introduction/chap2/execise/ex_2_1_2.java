package se.algorithm.Introduction.chap2.execise;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/10/17.
 */
public class ex_2_1_2 {
    public static void main(String[] args) {
        int[] a = {2,3,8,8,1,21,13,10,7};
        insert(a);
        System.out.println(Arrays.toString(a));
    }
    public  static void insert(int[] num) {
        for (int i = 1; i < num.length; i++) {
            int key = num[i];
            int j = i;
            for (;j > 0 && num[j - 1] < key; j--) {
                num[j] = num[j - 1];
            }
            num[j] = key;
        }
    }
}
