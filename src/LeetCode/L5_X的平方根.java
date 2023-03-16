package LeetCode;

public class L5_X的平方根 {
    // 二分查找,前提是元素必须有序
    public static int binarySearch(int x){
        int index = -1,left = 0,right = x;
        while (left <= right){
            int mid = (left + right) / 2;
            if (mid * mid <=x){
                index = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return index;
    }

    //牛顿迭代,迭代实现
    public static int newton(int x){
        double n = 1.0;
        while ((int)(x / n) != (int)(n)){
            n =  (x/n + n) / 2;
        }
        return (int)(n);
    }
    //牛顿迭代，递归实现
    public static int newton1(int x){
        return (int)sqrt(1,x);
    }
    public static double sqrt(double n,int x){
        double res = (x/n + n)/2;
        if (res == n){
            return n;
        }else {
            return sqrt(res,x);
        }
    }
    public static void main(String[] args) {
//        System.out.println(binarySearch(24));
        System.out.println(newton(2));
    }
}
