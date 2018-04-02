package algo.sort;

/**
 * Created by Administrator on 2018/4/2.
 */
public class ChooseSort implements Sortable {
    public static void main(String[] args) {
        NumberUtils.sort(NumberUtils.getRandomArs(20, 100), new ChooseSort());
    }

    @Override
    public String getSortName() {
        return "选择";
    }

    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[minIdx] > nums[j]) {
                    minIdx = j;
                }
            }
            swap(nums, minIdx, i);
        }
    }
}
