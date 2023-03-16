package LeetCode;

public class L9_ArrangeCoin {

    public static int arrangeCoins(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (num - sum < i)
                return i - 1;
            sum += i;
        }
        return 0;
    }

    public static int arrangeCoins1(int num) {
        /**
         * 使用二分法查找进行优化
         */
        int low = 0, high = num;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int cost = (mid * (1 + mid)) / 2; // 等差数列求和
            if (cost == num){
                return mid;
            }else if (cost > num){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));
        System.out.println(arrangeCoins1(10));
    }

}
