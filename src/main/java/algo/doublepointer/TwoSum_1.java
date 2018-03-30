package algo.doublepointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/30.
 * 只适合拍过序的，还不如hashmap通用
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        } else {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int temp = nums[low] + nums[high];
                if (temp == target) {
                    return new int[]{low, high};
                } else if (temp < target) {
                    low++;
                } else {
                    high--;
                }
            }
            return new int[0];
        }
    }

    public static int[] twoSumByMap(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
