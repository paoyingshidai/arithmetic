 package com.michael.sort;

public class InsertSort {

	public static Integer[] insertionSort(Integer[] arr) {
	    int len = arr.length;
	    int preIndex;
	    Integer current;

	    for (int i = 1; i < len; i++) {
	        preIndex = i - 1;
	        current = arr[i];
	        while(preIndex >= 0 && arr[preIndex] > current) {
	            arr[preIndex+1] = arr[preIndex];
	            preIndex--;
	        }
	        arr[preIndex+1] = current;
	    }
	    return arr;
	}


	public static Integer[] mySort(Integer[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int preIndex = i - 1;
			Integer selected = arr[i];

			while (preIndex >= 0 && arr[preIndex] > selected) {
				arr[preIndex + 1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex+1] = selected;
		}
		return arr;
	}



	public static void main(String[] args) {
		Integer[] arr = {2, 5, 6, 9, 8, 1, 3};
//		insertionSort(arr);
		mySort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
