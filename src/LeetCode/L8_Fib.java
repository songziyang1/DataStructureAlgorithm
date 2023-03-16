package LeetCode;

public class L8_Fib {
    public static int calculateFib(int num) {
        /**
         * 暴力递归
         * args:num表示斐波那契数列的第几项
         * 时间复杂度O(2**n)
         */
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return calculateFib(num - 1) + calculateFib(num - 2);
    }

    public static int calculateFib1(int num) {
        /**
         * 去重递归
         * 利用arr减少递归的次数
         * args:num表示斐波那契数列的第几项
         * 时间复杂度O(n)，空间复杂度O(n)
         */
        int[] arr = new int[num + 1];
        return recurse(arr, num);
    }

    private static int recurse(int[] arr, int num) {
        /**
         * 递归计算斐波那契数列第num项
         * args: arr 存储前 num 项的值
         */
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (arr[num] != 0) {
            return arr[num];
        }
        return arr[num] = recurse(arr, num - 1) + recurse(arr, num - 2);
    }

    public static int iterateFib(int num) {
        /**
         * 双指针迭代
         * 使用双指针算法+迭代减少空间复杂度(只保留 n-1和 n-2项)
         * 时间复杂度O(n),空间复杂度O(1)
         */
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        int low = 0, high = 1;
        for (int i = 2; i <= num; i++) {
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(calculateFib(10));  // 55
        System.out.println(calculateFib1(10));  // 55
        System.out.println(iterateFib(10));  // 55
    }
}
