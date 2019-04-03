package com.michael.sort;

public class SelectionSort {


	public static Integer[] selectionSort(Integer[] arr) {
	    int len = arr.length;
	    Integer minIndex, temp;
	    for (int i = 0; i < len - 1; i++) {
	        minIndex = i;
	        for (int j = i + 1; j < len; j++) {
	            if (arr[j] < arr[minIndex]) {     //Ѱ����С����
	                minIndex = j;                 //����С������������
	            }
	        }
	        temp = arr[i];
	        arr[i] = arr[minIndex];
	        arr[minIndex] = temp;
	    }
	    return arr;
	}


	/**
	 * ����ѭ��
	 * @param arr
	 * @return
	 */
	public static Integer[] mySort(Integer[] arr) {

		int len = arr.length;
		Integer targetIndex;
		for (int i = 0; i < len - 1; i++) {
			targetIndex = i;
			for (int j = i + 1; j < len; j++) {
				if (arr[targetIndex] > arr[j]) {
					targetIndex = j;
				}
			}

			Integer temp = arr[i];
			arr[i] = arr[targetIndex];
			arr[targetIndex] = temp;
		}

		return arr;
	}


	public static void main(String[] args) {

		Integer[] arr = {2, 5, 6, 9, 8, 1, 3};
//		selectionSort(arr);
		mySort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
