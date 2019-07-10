package com.michael.arithmetic.array;

/**
 * 最大子数组：
 * 给定一个包含正数和负数的数组，找出这个数组中一个连续的子数组，使得这个子数组之和最大
 */
public class MaxSubArray {

    /**
     * 分治法： https://www.cnblogs.com/Christal-R/p/Christal_R.html
     * @return
     */
    public int divide(int[] arr, int left, int right) {

        if (left == right) {
            return arr[left];
        } else {
            int m = (left + right) / 2;

            int l_max = divide(arr, left, m);
            int r_max = divide(arr, m + 1, right);
            int m_max = middleMax(arr, left, right, m);

            return Math.max(m_max, Math.max(l_max, r_max));
        }
    }

    public int middleMax(int[]arr, int left, int right, int middle) {
        int l_max = 0;
        int r_max = 0;
        int sum = 0;

        // 左边
        for (int i = middle; i > left; i--) {
            sum += arr[i];
            l_max = Math.max(l_max, sum);
        }

        sum = 0;
        for (int i = middle + 1; i < right; i++) {
            sum += arr[i];
            r_max = Math.max(r_max, sum);
        }
        return r_max + l_max;
    }


    /**
     * 动态规划：https://blog.csdn.net/J__Max/article/details/88043205
     * MS[i] = max {MS[i-1], A[i]}.
     *
     * https://blog.csdn.net/long_lance/article/details/85445768 ——>
     * 从数组的左边界开始，从左至右处理，记录到目前为止已经处理过的最大子数组。
     * 若已知A[1..j]的最大子数组，基于如下性质将解扩展为A[1...j+1]的最大子数组：
     * A[1...j+1]的最大子数组要么是A[1...j]的最大子数组，要么是某个子数组A[i...j+1]（1<=i<=j+1）。
     * 在已知A[1...j]的最大子数组的情况下，可以在线性时间内找出形如A[i...j+1]的最大子数组；
     *
     * 当前状态会影响下一个状态。动态规划
     *
     * 该题的方法是：从 0 开始遍历，一直遍历到 i， 如果sum(0, i) 小于 0， 则计算后面的子数组的和，然后在与前面的
     * 和最大的子数组进行比较，取最大的一段。
     *
     *
     * @param arr
     * @return
     */
    public int dynamic(int arr[]) {
        int max_sum = 0, tmp = 0;
        int start = 0, end = 0;     // 记录位置（非必要条件）
        for (int i = 0; i < arr.length; i++) {
            if (tmp > 0) {
                tmp += arr[i];
            } else {                // 当 tmp < 0 时，证明前面的子数组和小于0，则需要重新计算下一段子数组
                tmp = arr[i];
                start = i;
            }

            if (max_sum < tmp) {
                max_sum = tmp;
                end = i;
            }
        }
        System.out.println(start + " : " + end);
        return max_sum;
    }


    /**
     * kadane 算法, 这是解决该问题的最优解，时间复杂度为O(n).
     *
     * 论证为何 kadane 算法可以解决该问题
     *
     * @param arr
     * @return
     */
    public int kadane(int arr[]) {
        if (arr.length == 1) return arr[0];
        int maxEndingHere = arr[0], maxSoFar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 关键步骤：
            // 这个方法与动态规划相似，如果 maxEndingHere(i) = max(arr[i], maxEndingHere(i-1) + arr[i]) 取arr[i]成立，
            // 则 maxEndingHere(i-1) 必定为负数, 如果为负数，则取当前值arr[i], 所以跟动态规划类似
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] data = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.divide(data, 0, data.length - 1));
        System.out.println(maxSubArray.dynamic(data));
        System.out.println(maxSubArray.kadane(data));
    }

}
