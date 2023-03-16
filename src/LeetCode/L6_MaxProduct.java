package LeetCode;

import java.io.InputStream;
import java.util.Arrays;

public class L6_MaxProduct {
    public static int sort(int[] nums) {
        //时间复杂度O(NlogN)
        Arrays.sort(nums);
        int n = nums.length;
        // 比较三个正数的乘积最大值 和 两个负数一个正数的乘积最大值
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }


    public static int getMaxMin(int[] nums) {
        // 时间复杂度O(NlogN)
        //Integer.MAX_VALUE表示int数据类型的最大取值数：2 147 483 647
        //Integer.MIN_VALUE表示int数据类型的最小取值数：-2 147 483 648
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            // 寻找两个最小值
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
            // 寻找三个最大值
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        // 比较两种情况的最大值
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {
        System.out.println(sort(new int[]{-10, -12, 1, 2, 3, 5, 6, 7}));
        System.out.println(getMaxMin(new int[]{-10, -12, 1, 2, 3, 5, 6, 7}));
    }
}