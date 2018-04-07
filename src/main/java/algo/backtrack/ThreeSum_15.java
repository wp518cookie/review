package algo.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2018/3/30.
 * 给定一个包含 n 个整数的数组 S，是否存在属于 S 的三个元素 a，b，c 使得 a + b + c = 0 ？找出所有不重复的三个元素组合使三个数的和为零。
   注意：结果不能包括重复的三个数的组合。
 */
public class ThreeSum_15 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSumByBackTrace(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        threeSumBackTrace(nums, list, 0, new ArrayList<Integer>(), 0, 3);
        return list;
    }

    public static void threeSumBackTrace(int[] nums, List<List<Integer>> list, int start, List<Integer> temp, int target, int k) {
        int max = nums[nums.length - 1];
        if (nums[start] * k > target || max * k < target) {
            return;
        }
        if (k == 2) {
            int i = start;
            int j = nums.length - 1;
            while (i < j) {
                int result = nums[i] + nums[j];
                if (result < target) {
                    i++;
                    continue;
                } else if (result > target) {
                    j--;
                    continue;
                } else {
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    list.add(new ArrayList(temp));
                    temp.remove(temp.size() - 1);
                    temp.remove(temp.size() - 1);
                }
                while (++i < j && nums[i] == nums[i - 1]) {

                }
                while (--j > i && nums[j] == nums[j + 1]) {

                }
            }
        } else {
            for (int i = start; i < nums.length - 2; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                temp.add(nums[i]);
                threeSumBackTrace(nums, list, i + 1, temp, target - nums[i], k - 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        int mid, right;
        int max = nums[nums.length - 1] * 2;
        for (int left = 0; left < nums.length - 2 && nums[left] <= 0; left++) {
            if (nums[left] + max < 0) {
                continue;
            }
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }
            mid = left + 1;
            right = nums.length - 1;
            int target = 0 - nums[left];
            while (mid < right) {
                if (nums[mid] * 2 > target) {
                    break;
                }
                int result = nums[mid] + nums[right];
                if (result > target) {
                    right--;
                } else if (result < target) {
                    mid++;
                } else {
                    list.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    while (++mid < right && nums[mid] == nums[mid - 1]) {

                    }
                    while (--right > mid && nums[right] == nums[right + 1]) {

                    }
                }
            }
        }
        return list;
    }
}
