package com.michael.sort;

/**
 * 冒泡排序
 * @author Michael
 */
public class BubbleSort {

	public static Integer[] bubbleSort(Integer[] arr) {
	    int len = arr.length;
	    for (int i = 0; i < len; i++) {
	        for (int j = 0; j < len - 1 - i; j++) {  // ĩβ�ľͲ���Ҫ�Ƚ���
	            if (arr[j] > arr[j+1]) {        	 //����Ԫ�������Ա�
	            	Integer temp = arr[j+1];         //Ԫ�ؽ���
	                arr[j+1] = arr[j];
	                arr[j] = temp;
	            }
	        }
	    }
	    return arr;
	}


	public static Integer[] mySort(Integer[] arr) {

		int len = arr.length;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len-1-i; j++) {
				if (arr[j] > arr[j+1]) {
					Integer temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}




	public static void main(String[] args) {
		Integer[] arr = {2, 5, 6, 9, 8, 1, 3};
//		bubbleSort(arr);
		mySort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
