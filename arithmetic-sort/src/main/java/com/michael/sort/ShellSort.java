package com.michael.sort;

import java.util.Arrays;

public class ShellSort {

    /**
     * just like insertSort plus;
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
     *
     * @param data
     */
    public static void mySort(int[] data) {
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
             for (int i = increment; i < data.length; i++) {
                 int temp = data[i];
                 int j;
                 for (j = i - increment; j >= 0; j -= increment) {
                     if (temp < data[j]) {      // 这里的 大于或者小于 就决定了升序或者降序
                         data[j + increment] = data[j]; // 将大的数放在后面
                     } else {
                         break;
                     }
                 }
                 data[j + increment] = temp;
             }
        }
    }


    public static void main(String[] args) {
//        int[] data = new int[] { 26, 53, 67, 48, 57, 13, 48, 32, 60, 50 };
        int[] data = new int[] {60, 50, 26, 53, 67, 48, 57, 13, 48, 32, 1};
        System.out.println(Arrays.toString(data));
//        shellSortSmallToBig(data);
        mySort(data);
        System.out.println();
        System.out.println(Arrays.toString(data));
    }

}
