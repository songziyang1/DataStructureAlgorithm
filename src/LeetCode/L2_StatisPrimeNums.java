package LeetCode;

public class L2_StatisPrimeNums {
    // 暴力算法
    public static int enumerate(int n) {
        int count = 0;  // 用于统计素数的个数
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0; // 是素数的话+1，否则+0
        }
        return count;
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
//        System.out.println(x);
        return true;
    }

    public static int eratosthenes(int n) {
        boolean[] isPrime = new boolean[n]; //初始化为false，false代表素数
        int count = 0; //统计素数的个数
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                //如果是素数的话，count++
                count++;
                for (int j = i * i; j < n; j += i) {
                    //2*i,3*i,4*i,5*i,6*i
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = enumerate(100);
//        int count = eratosthenes(100);
        System.out.println(count);
    }
}