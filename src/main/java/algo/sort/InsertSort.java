package algo.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/4/2.
 */
public class InsertSort implements Sortable {
    public static void main(String[] args) {
        NumberUtils.sort(NumberUtils.getRandomArs(20, 100), new InsertSort());
    }

    @Override
    public String getSortName() {
        return "插入";
    }

    @Override
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }
}
