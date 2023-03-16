package LeetCode;

import java.util.Arrays;

public class L4_寻找数组的中心下标 {

    //双指针法
    public static int pivotIndex(int[] nums){
        int total = 0,sum = 0;
        sum = Arrays.stream(nums).sum();
        System.out.println(sum);
        for (int i = 0;i < nums.length;i++){
            total += nums[i];
            if (total == sum){
                return i;
            }
            sum -= nums[i];
        }
        return -1;
    }

    //公式法
    public static int pivotIndex1(int[] nums){
        int total = 0;
        int sum = Arrays.stream(nums).sum();
        for (int i = 0;i < nums.length;i++){
            if (2*total + nums[i] == sum){
                return i;
            }
            total += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex1(new int[]{2,3,5,1,4}));
    }
}
