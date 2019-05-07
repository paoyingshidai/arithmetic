package com.michael.sort.my;


/**
 * øÏÀŸ≈≈–Ú
 * @author Michael
 *
 */
public class QuickSort {


	public static int partition(int[]arr, int low, int high) {

		int key = arr[low];

		while(low < high) {
			while(arr[high] >= key && low < high) {
				high--;
			}
			arr[low] = arr[high];
			while(arr[low] <= key && low < high) {
				low++;
			}
			arr[high] = arr[low];
		}
		arr[high] = key;
		return high;
	}


	public static void sort(int[]arr, int low, int high) {

		if (low >= high) return;

		int index = partition(arr, low, high);
		sort(arr, low, index -1);
		sort(arr, index + 1, high);
	}

	public static void main(String[] args) {
	    int[] arr = {1,9,3,12,7,8,3,4,65,22};

	    sort(arr, 0, arr.length - 1);

	    for(int i : arr){
	        System.out.print(i+",");
	    }
	}

}
