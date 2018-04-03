package algo.sort;

/**
 * Created by Administrator on 2018/4/3.
 */
public class RadixSort implements Sortable {
    public static void main(String[] args) {
        NumberUtils.sort(NumberUtils.getRandomArs(500, 1000), new RadixSort());
    }

    @Override
    public String getSortName() {
        return "基数";
    }

    @Override
    public void sort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int d = 0;
        while (max != 0) {
            max /= 10;
            d++;
        }
        sort(nums, d);
    }

    public void sort(int[] nums, int d) {
        int n = 1;
        int times = 1;
        int[][] temp = new int[10][nums.length];
        while (times <= d) {
            int[] order = new int[10];
            for (int i = 0; i < nums.length; i++) {
                int lsd = ((nums[i] / n) % 10);
                temp[lsd][order[lsd]] = nums[i];
                order[lsd]++;
            }
            int k = 0;
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        nums[k] = temp[i][j];
                        k++;
                    }
                }
            }
            n *= 10;
            times++;
        }
    }
}
