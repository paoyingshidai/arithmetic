package com.michael.sort;

/**
 * 冒泡排序
 * @author Michael
 */
public class BubbleSort {

	public static Integer[] bubbleSort(Integer[] arr) {
	    int len = arr.length;
	    for (int i = 0; i < len; i++) {
	        for (int j = 0; j < len - 1 - i; j++) {  // 末尾的就不需要比较了
	            if (arr[j] > arr[j+1]) {        	 //相邻元素两两对比
	            	Integer temp = arr[j+1];         //元素交换
	                arr[j+1] = arr[j];
	                arr[j] = temp;
	            }
	        }
	    }
	    return arr;
	}

	public static void main(String[] args) {
		Integer[] arr = {2, 5, 6, 9, 8, 1, 3};
		bubbleSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
