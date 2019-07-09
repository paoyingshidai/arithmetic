package com.michael.arithmetic.array;

/**
 * 最大子数组：
 * 给定一个包含正数和负数的数组，找出这个数组中一个连续的子数组，使得这个子数组之和最大
 */
public class MaxSubArray {

    /**
     * 分治法
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


    public static void main(String[] args) {
        int[] data = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.divide(data, 0, data.length - 1));

    }


}
