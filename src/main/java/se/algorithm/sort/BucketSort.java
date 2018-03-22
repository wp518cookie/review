package se.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Administrator on 2018/3/15.
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 6, 10};
        sort(arr);
    }
    public static void sort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / arr.length;
            bucketArr.get(num).add(arr[i]);
        }
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }
        System.out.println(bucketArr.toString());
    }
}
