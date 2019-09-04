package com.michael.sort;


/**
 * 快速排序 详细： https://blog.csdn.net/pengzonglu7292/article/details/84938910
 * @author windows
 *
 */
public class QuickSort {

	/**
	 * 一次快速排序
	 * @param array 数组
	 * @param low 数组的前下标
	 * @param high 数组的后下标
	 * @return key的下标index，也就是分片的间隔点
	 */
	public static int partition(int []array, int low, int high){
	    /** 固定的切分方式 */
	    int base = array[low];// 选取了基准点
	    while(low < high) {
	        // 从后半部分向前扫描, 找到小于基准点的数
	        while(array[high] >= base && high > low) {
	            high--;
	        }
	        // 低于基准点的就交换
	        array[low] = array[high];


	        // 从前半部分向后扫描，找到大于基准点的数
	        while(array[low] <= base && high > low) {
	            low++;
	        }
			// 高于基准点的就交换
	        array[high] = array[low];
	    }
	    array[high] = base;	// 最后把基准存入
	    return high;
	}


	/**
	 * 快速排序
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] array, int low, int high){
	    if(low >= high){
	        return ;
	    }
	    //进行第一轮排序获取分割点
	    int index = partition(array, low, high);
	    //排序前半部分
	    quickSort(array, low, index - 1);
	    //排序后半部分
	    quickSort(array,index+1, high);
	}


	public static void main(String[] args) {
	    int[] arr = {1,9,3,12,7,8,3,4,65,22};

//	    quickSort(arr, 0, arr.length - 1);
	    sortq(arr, 0, arr.length - 1);

	    for(int i : arr){
	        System.out.print(i+",");
	    }
	}


	private static int sort(int[] array, int low, int high) {

		int base = array[low];

		while(low < high) {

			while(array[high] >= base && low < high) {
				high--;
			}
			array[low] = array[high];

			while(array[low] <= base && low < high) {
				low++;
			}
			array[high] = array[low];
		}
		array[high] = base;

		return high;
	}

	public static void sortq(int[] array, int low, int high) {

		if (low >= high) return;

		int index = sort(array, low, high);

		sortq(array, low, index);

		sortq(array, index + 1, high);

	}


}
