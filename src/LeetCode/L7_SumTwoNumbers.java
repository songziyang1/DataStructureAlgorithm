package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L7_SumTwoNumbers {
    // ======================��������=====================================
    public static int[] solution(int[] nums, int target) {
        int len = nums.length;
        // ����ѭ��, O(n**2)
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    public static int[] solution1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        // ����ѭ��,ʱ�临�Ӷ�O(n),map�Ŀռ临�Ӷ�ΪO(n)
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    // ======================��������==================================
    public static int[] twoSearch(int[] nums, int target){
        // ���ֲ���,ʱ�临�Ӷ�  O(nlogn)���ռ临�Ӷ�O(1)
        for (int i = 0; i < nums.length; i++) {
            int low = i,hight = nums.length - 1;
            while (low <= hight){
                int mid = (hight - low)/2 + low;
                if (nums[mid] == target - nums[i]){
                    return new int[]{i,mid};
                }else if (nums[mid] > target - nums[i]){
                    hight = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return new int[]{0};
    }

    public static int[] twoPoint(int[] nums, int target){
        // ˫ָ�뷨��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1),���Ž⣬ǰ������������
        int low = 0,high = nums.length - 1;
        while (low < high){
            if (nums[low] + nums[high] == target){
                return new int[]{low,high};
            }else if (nums[low] + nums[high] > target){
                high--;
            }else{
                low++;
            }
        }
        return new int[]{0};
    }

    public static void main(String[] args) {
        int target = 10;
        // ��������
        System.out.println(Arrays.toString(solution(new int[]{4, 5, 6, 1, 2, 3}, target)));
        System.out.println(Arrays.toString(solution1(new int[]{4, 5, 6, 1, 2, 3}, target)));
        // ��������
        System.out.println(Arrays.toString(twoSearch(new int[]{1, 2, 3, 4, 5, 6}, target)));
        System.out.println(Arrays.toString(twoPoint(new int[]{1, 2, 3, 4, 5, 6}, target)));
    }
}
