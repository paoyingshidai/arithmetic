package com.michael.sort;


/**
 * ��������
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
	    int key = array[low];//ѡȡ�˻�׼��
	    while(low < high) {
	        //�Ӻ�벿����ǰɨ��
	        while(array[high] >= key && high > low) {
	            high--;
	        }
	        // ���ڻ�׼��ľͽ���
	        array[low] = array[high];
	        //��ǰ�벿�����ɨ��
	        while(array[low] <= key && high > low) {
	            low++;
	        }
			// ���ڻ�׼��ľͽ���
	        array[high] = array[low];
	    }
	    array[high] = key;//���ѻ�׼����
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
	    quickSort(array,index+1,high);
	}


	public static void main(String[] args) {
	    int[] arr = {1,9,3,12,7,8,3,4,65,22};

	    quickSort(arr, 0, arr.length - 1);

	    for(int i : arr){
	        System.out.print(i+",");
	    }
	}

}
