package se.algorithm.yellow.chap3;

/**
 * Created by Administrator on 2017/11/30.
 */
public class MyBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,3,4,6,7,9,11};
        System.out.println(binarySearch(4, arr));
    }
    public static boolean binarySearch(int val, int[] arr) {
        int low = 0;
        int end = arr.length - 1;
        while (low <= end) {
            int mid = (low + end) / 2;
            if (val == arr[mid]) {
                return true;
            } else if (val > arr[mid]) {
                low = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
