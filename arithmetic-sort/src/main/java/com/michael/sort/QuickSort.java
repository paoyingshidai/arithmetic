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
	 * @param lo �����ǰ�±�
	 * @param hi ����ĺ��±�
	 * @return key���±�index��Ҳ���Ƿ�Ƭ�ļ����
	 */
	public static int partition(int []array,int lo,int hi){
	    /** �̶����зַ�ʽ */
	    int key=array[lo];//ѡȡ�˻�׼��
	    while(lo<hi){
	        //�Ӻ�벿����ǰɨ��
	        while(array[hi]>=key&&hi>lo){
	            hi--;
	        }
	        array[lo]=array[hi];
	        //��ǰ�벿�����ɨ��
	        while(array[lo]<=key&&hi>lo){
	            lo++;
	        }
	        array[hi]=array[lo];
	    }
	    array[hi]=key;//���ѻ�׼����
	    return hi;
	}


	/**
	 * ��������
	 * @param array
	 * @param lo
	 * @param hi
	 */
	public static void quickSort(int[] array,int lo ,int hi){
	    if(lo>=hi){
	        return ;
	    }
	    //���е�һ�������ȡ�ָ��
	    int index=partition(array,lo,hi);
	    //����ǰ�벿��
	    quickSort(array, lo, index - 1);
	    //�����벿��
	    quickSort(array,index+1,hi);
	}


	public static void main(String[] args) {
	    int[] arr = {1,9,3,12,7,8,3,4,65,22};

	    quickSort(arr, 0, arr.length-1);

	    for(int i:arr){
	        System.out.print(i+",");
	    }
	}

}
