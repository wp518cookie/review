package algo.sort;

/**
 * Created by Administrator on 2018/4/3.
 */
public class DumpSort implements Sortable {
    public static void main(String[] args) {
        NumberUtils.sort(NumberUtils.getRandomArs(2000, 10000), new DumpSort());

    }

    @Override
    public void sort(int[] nums) {
        for (int i = (nums.length / 2) - 1; i >= 0; i--) {
            makeDump(nums, i, nums.length - 1);
        }
        int times = nums.length - 1;
        while (times > 0) {
            swap(nums, 0, times);
            times--;
            makeDump(nums, 0, times);
        }
    }

    @Override
    public String getSortName() {
        return "堆";
    }

    private void makeDump(int[] nums, int i, int end) {
        int temp = nums[i];
        for (int k = 2 * i + 1; k <= end; k = k * 2 + 1) {
            if (k + 1 <= end && nums[k] < nums[k + 1]) {
                k++;
            }
            if (nums[k] > temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }
}
