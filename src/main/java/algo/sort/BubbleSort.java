package algo.sort;

/**
 * Created by Administrator on 2018/4/2.
 */
public class BubbleSort implements Sortable {
    public static void main(String[] args) {
        NumberUtils.sort(NumberUtils.getRandomArs(20, 100), new BubbleSort());
    }

    @Override
    public String getSortName() {
        return "冒泡";
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean changed = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
    }
}
