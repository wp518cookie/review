package algo.sort;

/**
 * Created by Administrator on 2018/4/3.
 */
public class QuickSort implements Sortable {
    public static void main(String[] args) {
        NumberUtils.sort(NumberUtils.getRandomArs(500, 2000), new QuickSort());
    }

    @Override
    public String getSortName() {
        return "快速";
    }

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            int low = left;
            int high = right;
            int pivot = low;
            while (low < high) {
                while (high > low && nums[high] >= nums[pivot]) {
                    high--;
                }
                while (low < high && nums[low] <= nums[pivot]) {
                    low++;
                }
                if (low < high) {
                    swap(nums, low, high);
                }
            }
            swap(nums, pivot, low);
            sort(nums, left, low - 1);
            sort(nums, low + 1, right);
        }
    }
}
