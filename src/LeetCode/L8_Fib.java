package LeetCode;

public class L8_Fib {
    public static int calculateFib(int num) {
        /**
         * �����ݹ�
         * args:num��ʾ쳲��������еĵڼ���
         * ʱ�临�Ӷ�O(2**n)
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
         * ȥ�صݹ�
         * ����arr���ٵݹ�Ĵ���
         * args:num��ʾ쳲��������еĵڼ���
         * ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
         */
        int[] arr = new int[num + 1];
        return recurse(arr, num);
    }

    private static int recurse(int[] arr, int num) {
        /**
         * �ݹ����쳲��������е�num��
         * args: arr �洢ǰ num ���ֵ
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
         * ˫ָ�����
         * ʹ��˫ָ���㷨+�������ٿռ临�Ӷ�(ֻ���� n-1�� n-2��)
         * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
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
