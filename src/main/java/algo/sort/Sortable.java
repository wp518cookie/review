package algo.sort;

/**
 * Created by Administrator on 2018/4/2.
 */
public interface Sortable {
    void sort(int[] nums);
    String getSortName();
    default void swap(int[] arr, int i, int j) {
        //不能有相同值，不然会有错,注意和的范围溢出
        if (i != j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
    }
}
