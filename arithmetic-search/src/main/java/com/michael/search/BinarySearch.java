package com.michael.search;

/**
 * 二分查找算法（有序）
 *
 * 递归与非递归
 */
public class BinarySearch {

    // 二分查找（折半查找），版本1
    public static int BinarySearch1(int a[], int value, int n) {
        int low, high, mid;
        low = 0;
        high = n-1;
        while(low <= high)
        {
            mid = (low + high) / 2;
            if(a[mid] == value)
                return mid;
            if(a[mid] > value)
                high = mid-1;
            if(a[mid] < value)
                low = mid+1;
        }
        return -1;
    }

    // 二分查找，递归版本
    public static int BinarySearch2(int srcArray[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return BinarySearch2(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return BinarySearch2(srcArray, start, mid - 1, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int srcArray[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        System.out.println(BinarySearch2(srcArray, 0, srcArray.length - 1, 81));
        System.out.println(BinarySearch1(srcArray, 81, srcArray.length));
    }


}
