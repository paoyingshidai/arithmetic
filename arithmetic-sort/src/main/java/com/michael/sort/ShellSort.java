package com.michael.sort;

import java.util.Arrays;

public class ShellSort {

    /**
     * just like insertSort plus;
     *
     * @param data
     */
    public static void shellSortSmallToBig(int[] data) {
        int j = 0;
        int temp = 0;
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                temp = data[i];
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
            for (int i = 0; i < data.length; i++)
                System.out.print(data[i] + " ");
            System.out.println();
        }
    }


    /**
     * @param data
     */
    public static void mySort(int[] data) {
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) { // 插入排序的 increment = 1;
                int temp = data[i];
                int j = i - increment;

                // 这是插入排序的写法
                while (j >= 0 && temp < data[j]) {
                    data[j + increment] = data[j];
                    j -= increment;
                }
                data[j + increment] = temp;
            }
        }
    }


    public static void main(String[] args) {
//        int[] data = new int[] { 26, 53, 67, 48, 57, 13, 48, 32, 60, 50 };
        int[] data = new int[]{60, 50, 26, 53, 67, 48, 57, 13, 48, 32, 1};
        System.out.println(Arrays.toString(data));
//        shellSortSmallToBig(data);
        mySort(data);
        System.out.println();
        System.out.println(Arrays.toString(data));
    }

}
