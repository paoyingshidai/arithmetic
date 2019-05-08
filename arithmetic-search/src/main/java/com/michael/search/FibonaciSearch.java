package com.michael.search;

public class FibonaciSearch {

    /**
     * 斐波那契数列
     * 采用递归
     */
    public static int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fib(n-1)+fib(n-2);
    }

    /**
     * 斐波那契数列
     * 不采用递归
     */
    public static int fib2(int n) {
        int a=0;
        int b=1;
        if(n==0)
            return a;
        if(n==1)
            return b;
        int c=0;
        for(int i=2;i<=n;i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

    /**
     * 斐波那契查找
     */
    public static int fibSearch(int[] arr, int n, int key) {
        int low = 1;      //记录从1开始
        int high = n;     //high不用等于fib(k)-1，效果相同
        int mid;

        int k = 0;
        while(n > fib(k) - 1)    //获取k值
            k++;
        int[] temp = new int[fib(k)];   //因为无法直接对原数组arr[]增加长度，所以定义一个新的数组
        System.arraycopy(arr, 0, temp, 0, arr.length); //采用System.arraycopy()进行数组间的赋值
        for(int i = n+1; i <= fib(k) - 1; i++)    //对数组中新增的位置进行赋值
            temp[i]=temp[n];

        while(low <= high) {
            mid = low + fib(k - 1) - 1;
            if(temp[mid] > key) {
                high=mid - 1;
                k = k - 1;  //对应上图中的左段，长度F[k-1]-1
            }else if(temp[mid] < key) {
                low = mid + 1;
                k = k - 2;  //对应上图中的右端，长度F[k-2]-1
            }else {
                if(mid <= n)
                    return mid;
                else
                    return n;       //当mid位于新增的数组中时，返回n
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,16,24,35,47,59,62,73,88,99};
        int n=10;
        int key=59;
        System.out.println(fibSearch(arr, n, key));  //输出结果为：6
    }
}
