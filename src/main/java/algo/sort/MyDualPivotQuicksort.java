package algo.sort;

/**
 * Created by Administrator on 2018/4/4.
 */
public class MyDualPivotQuicksort {
    private static final int QUICKSORT_THRESHOLD = 286;
    private static final int INSERTION_SORT_THRESHOLD = 47;

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1, null, 0, 0);
    }

    private static void sort(int[] a, int left, int right, int[] work, int workBase, int workLen) {
        if (right - left < QUICKSORT_THRESHOLD) {
            sort(a, left, right, true);
            return;
        }
    }

    private static void sort(int[] a, int left, int right, boolean leftmost) {
        int length = right - left + 1;
        //使用插入算法
        if (length < INSERTION_SORT_THRESHOLD) {
            if (leftmost) {
                for (int i = left, j = i; i < right; j = ++i) {
                    int ai = a[i + 1];
                    while (a[j] > ai) {
                        a[j + 1] = a[j];
                        if (j-- == left) {
                            break;
                        }
                    }
                    a[j + 1] = ai;
                }
            } else {
                do {
                    if (left >= right) {
                        return;
                    }
                } while (a[++left] >= a[left - 1]);
                for (int k = left; ++left <= right; k = ++left) {
                    int a1 = a[k], a2 = a[left];
                    //todo 这他么是什么算法？
                }
            }
        }
        int seventh = (length >> 3) + (length >> 6) + 1;
        int e3 = (left + right) >>> 1;
        int e2 = e3 - seventh;
        int e1 = e2 - seventh;
        int e4 = e3 + seventh;
        int e5 = e4 + seventh;

        if (a[e2] < a[e1]) {
            int t = a[e2];
            a[e2] = a[e1];
            a[e1] = t;
        }

    }
}
