package algo.doublepointer;

/**
 * Created by ping.wu on 2018/3/31.
 */
public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int vol;
        int volMax = Math.min(height[low], height[high]) * (height.length - 1);
        while (low < high) {
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
            vol = Math.min(height[low], height[high]) * (high - low);
            if (vol > volMax) {
                volMax = vol;
            }
        }
        return volMax;
    }
    //可优化
    public int maxAreaFaster(int[] height) {
        int low = 0;
        int high = height.length - 1;
        int max = 0;
        int res;
        while (low < high) {
            if (height[low] < height[high]) {
                res = height[low] * (high - low);
                low++;
            } else {
                res = height[high] * (high - low);
                high--;
            }
            if (res > max) {
                max = res;
            }
        }
        return max;
    }
}
