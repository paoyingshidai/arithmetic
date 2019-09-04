package com.michael.sort;


/**
 * �������� ��ϸ�� https://blog.csdn.net/pengzonglu7292/article/details/84938910
 * @author windows
 *
 */
public class QuickSort {

	/**
	 * һ�ο�������
	 * @param array ����
	 * @param low �����ǰ�±�
	 * @param high ����ĺ��±�
	 * @return key���±�index��Ҳ���Ƿ�Ƭ�ļ����
	 */
	public static int partition(int []array, int low, int high){
	    /** �̶����зַ�ʽ */
	    int base = array[low];// ѡȡ�˻�׼��
	    while(low < high) {
	        // �Ӻ�벿����ǰɨ��, �ҵ�С�ڻ�׼�����
	        while(array[high] >= base && high > low) {
	            high--;
	        }
	        // ���ڻ�׼��ľͽ���
	        array[low] = array[high];


	        // ��ǰ�벿�����ɨ�裬�ҵ����ڻ�׼�����
	        while(array[low] <= base && high > low) {
	            low++;
	        }
			// ���ڻ�׼��ľͽ���
	        array[high] = array[low];
	    }
	    array[high] = base;	// ���ѻ�׼����
	    return high;
	}


	/**
	 * ��������
	 * @param array
	 * @param low
	 * @param high
	 */
	public static void quickSort(int[] array, int low, int high){
	    if(low >= high){
	        return ;
	    }
	    //���е�һ�������ȡ�ָ��
	    int index = partition(array, low, high);
	    //����ǰ�벿��
	    quickSort(array, low, index - 1);
	    //�����벿��
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
