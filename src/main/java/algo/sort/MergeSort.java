package algo.sort;

/**
 * Created by Administrator on 2018/4/3.
 */
public class MergeSort implements Sortable {
    public static void main(String[] args) {
        NumberUtils.sort(NumberUtils.getRandomArs(500, 20000), new MergeSort());
    }

    @Override
    public String getSortName() {
        return "归并";
    }

    @Override
    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] tempArr = new int[end - start + 1];
        for (int k = 0; k < tempArr.length; k++) {
            if (i > mid) {
                tempArr[k] = nums[j++];
            } else if (j > end) {
                tempArr[k] = nums[i++];
            } else if (nums[i] > nums[j]) {
                tempArr[k] = nums[j++];
            } else {
                tempArr[k] = nums[i++];
            }
        }
        for (int k = 0; k < tempArr.length; k++) {
            nums[k + start] = tempArr[k];
        }
    }
}
