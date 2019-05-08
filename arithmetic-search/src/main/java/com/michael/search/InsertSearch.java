package com.michael.search;

/**
 * 插值查找算法
 *
 */
public class InsertSearch {

    public static int InsertSearch2(int srcArray[], int start, int end, int key) {
        // 与二分查找的区别是中值的确定
        int mid =  start + (end - start) * (key - srcArray[start]) / (srcArray[end] - srcArray[start]);
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return InsertSearch2(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return InsertSearch2(srcArray, start, mid - 1, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int srcArray[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        System.out.println(InsertSearch2(srcArray, 0, srcArray.length - 1, 81));
    }


}
