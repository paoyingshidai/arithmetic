package com.michael.sort.my;

/**
 * —°‘Ò≈≈–Ú
 * @author Michael
 */
public class SelectionSort {

	public static Integer[] selectionSort(Integer[] arr) {

		int minIndex;
		Integer temp;
		int len = arr.length;

		for (int i = 0; i < len - 1; i++) {
			minIndex = i;

			for (int j = i + 1; j < len; j++) {

				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}


	public static void main(String[] args) {
		Integer[] arr = {2, 5, 6, 9, 8, 1, 3};
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
