package com.michael.sort;

/**
 * https://www.cnblogs.com/Gabby/p/6523148.html
 * @author windows
 *
 */
public class CountingSort {

	public static void sortByAsc(int[] data) {
        if(data == null || data.length <= 1)
            return;
        /** find the range of data */
        int range = data[0];
        for(int i = 1; i< data.length; i++){
            if(range < data[i]){
                range = data[i];
            }
        }
         if (range <= 0) {
             System.out.println("边界不能为负数");
             return;
         }
        /** count sort */
        countSortByAsc(data,range);

    }

    private static void countSortByAsc(int[] data, int range) {

        /**建一个长度为range+1的的数组countArray，里面的每一个元素初始都置为0(Java里面默认就是0)。*/
        int[] countArray = new int[range + 1];
        /**遍历待排序的数组，计算其中的每一个元素出现的次数，比如一个key为i的元素出现了3次，那么countArray[i]=3。*/
        for(int i = 0;i < data.length; i++){
            int val = data[i];
            if(val < 0 || val > range){
                System.out.println("下标超界");
                 return;
            }
            countArray[val] += 1;
        }
        for(int i = 0,index = 0;i < countArray.length ; i++){
            for(int j = 0; j <countArray[i];j++ ){
                    data[index] = i;
                    index++;
            }

        }

    }


    public static  void sortByDesc(int[] data) {
        if(data == null || data.length <= 1)
            return;
        /** find the range of data */
        int range = data[0];
        for(int i = 1; i< data.length; i++){
            if(range < data[i]){
                range = data[i];
            }
        }
         if (range <= 0) {
             System.out.println("边界不能为负数");
             return;
         }
        /** count sort */
        countSortByDesc(data,range);

    }

    private static void countSortByDesc(int[] data, int range) {
        /**建一个长度为range+1的的数组countArray，里面的每一个元素初始都置为0(Java里面默认就是0)。*/
        int[] countArray = new int[range + 1];
        /**遍历待排序的数组，计算其中的每一个元素出现的次数，比如一个key为i的元素出现了3次，那么countArray[i]=3。*/
        for(int i = 0;i < data.length; i++){
            int val = data[i];
            if(val < 0 || val > range){
                System.out.println("下标超界");
                 return;
            }
            countArray[val] += 1;
        }
        for(int i = countArray.length - 1,index = 0;i >=0 ; i--){
            for(int j = 0; j <countArray[i];j++ ){
                    data[index] = i;
                    index++;
            }

        }

    }


    public static void main(String[] args) {

    	int[] arr = {1,9,3,12,7,8,3,4,65,22};

    	System.out.println("降序");
    	sortByDesc(arr);
    	for(int i:arr){
    		System.out.print(i+",");
    	}
    	System.out.println();
    	System.out.println("升序");
    	sortByAsc(arr);
	    for(int i:arr){
	        System.out.print(i+",");
	    }

	}

}
