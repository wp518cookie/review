package algo.doublepointer;

/**
 * Created by ping.wu on 2018/3/31.
 */
public class RemoveDuplicatesFromSortedArray_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int j = 1;
        int before = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != before) {
                nums[j++] = nums[i];
                before = nums[i];
            }
        }
        return j;
    }
}
