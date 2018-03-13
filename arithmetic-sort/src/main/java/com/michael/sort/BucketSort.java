package com.michael.sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BucketSort {

	    /**
	     * @param args
	     */
	    public static void main(String[] args) {
	        File file = new File("./src/bucketSort/sample.txt");
	        Scanner sc = null;
	        try {
	            sc = new Scanner(file);
	            //��ȡ�������ĸ���
	            int T = sc.nextInt();
	            for(int i=0; i<T; i++){
	                //��ȡÿ����������Ԫ�ظ���
	                int N = sc.nextInt();
	                //��ȡͰ�ĸ���
	                int M = sc.nextInt();
	                int A[] = new int[N];
	                for(int j=0; j<N; j++){
	                    A[j] = sc.nextInt();
	                }
	                bucketSort(A, M);
	                printResult(i, A);
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } finally {
	            if(sc != null){
	                sc.close();
	            }
	        }
	    }

	    /**
	     * ��������Ԫ�ؾ���Ͱ�ĸ�����M����������󣬴����Ǹ�Ͱ�У��õ�Ͱ���±�������
	     * ����1
	     * ע�⣺
	     * �����������ʵ����Ͱ�����е���Ժ��ĵĲ��֣�Ҳ���ǳ�˵�Ĵ�����������Ͱ֮���ӳ�����f��x���Ķ��岿�֡�
	     * ���ӳ����򣬶���Ͱ�����㷨�Ĳ�ͬʵ�ְ汾����������ͬ��
	     *
	     * @param elem ԭʼ���������е�Ԫ��ֵ
	     * @param m Ͱ��������Ӱ��Ͱ�ĸ�����
	     * @return Ͱ�������ţ���ţ�
	     */
	    private static int getBucketIndex(int elem, int m){
	        return elem / m;
	    }

	    private static void bucketSort(int src[], int m){
	        //����һ�����������Ͱ��ԭʼ���ݴ�С��ӳ���ϵ
	        HashMap<Integer, ArrayList<Integer>> buckets = new HashMap<Integer, ArrayList<Integer>>();

	        //�滮������Ͱ  ������2��
	        programBuckets(src, m, buckets);

	        //��Ͱ����Ͱ�ı�Ž���������ſ����Ǹ�����������3��
	        Integer bkIdx[] = new Integer[buckets.keySet().size()];
	        buckets.keySet().toArray(bkIdx);
	        quickSort(bkIdx, 0, bkIdx.length - 1);

	        //����ÿ��Ͱ��Ӧ���������ռ����ʵλ��
	        HashMap<Integer, Integer> bucketIdxPosMap = new HashMap<Integer, Integer>();
	        int startPos = 0;
	        for(Integer idx: bkIdx){
	            bucketIdxPosMap.put(idx, startPos);
	            startPos += buckets.get(idx).size();
	        }

	        //��Ͱ�ڵ����ݲ�ȡ��������,���������Ľ��ӳ�䵽ԭʼ��������Ϊ���
	        for(Integer bId : buckets.keySet()){
	            ArrayList<Integer> bk = buckets.get(bId);
	            Integer[] org = new Integer[bk.size()];
	            bk.toArray(org);
	            quickSort(org, 0, bk.size() - 1); //��Ͱ�����ݽ������� ������4��
	            //������������ӳ�䵽ԭʼ��������Ϊ��� ������5��
	            int stPos = bucketIdxPosMap.get(bId);
	            for(int i=0; i<org.length; i++){
	                src[stPos++] = org[i];
	            }
	        }
	    }

	    /**
	     * ����ԭʼ���ݺ�Ͱ�ĸ����������ݽ�����Ͱ�滮��
	     *
	     * ������̣���������divide-and-conquer��˼��
	     *
	     * @param src
	     * @param m
	     * @param buckets
	     */
	    private static void programBuckets(int[] src, int m, HashMap<Integer, ArrayList<Integer>> buckets) {
	        for(int i=0; i<src.length; i++){
	            int bucketIdx = getBucketIndex(src[i], m);

	            ArrayList<Integer> bucket = buckets.get(bucketIdx);
	            if(bucket == null){
	                //����Ͱ��������ų������ֺõ�ԭʼ����
	                bucket = new ArrayList<Integer>();
	                buckets.put(bucketIdx, bucket);
	            }
	            bucket.add(src[i]);
	        }
	    }

	    /**
	     * �����������߼бƵķ�ʽ��������������м�ĳ��λ�üбƣ���ԭ����������зָ�������֣���ߵĲ���ȫ��С��ĳ��ֵ��
	     * �ұߵĲ���ȫ������ĳ��ֵ��
	     *
	     * �����㷨�ĺ��Ĳ��֡�
	     *
	     * @param src ����������
	     * @param start ������������
	     * @param end ������յ�����
	     * @return ��ֵ����
	     */
	    private static int middle(Integer src[], int start, int end){
	        int middleValue = src[start];
	        while(start < end){
	            //�ҵ��Ұ벿�ֶ���middleValue��ķֽ��
	            while(src[end] >= middleValue && start < end){
	                end--;
	            }
	            //��������middleValueС��ʱ�����start����С��end�����Ƚϵ����ֵ�滻Ϊ�µ���Сֵ���
	            src[start] = src[end];
	            //�ҵ���벿�ֶ���middleValueС�ķֽ��
	            while(src[start] <= middleValue && start < end){
	                start++;
	            }
	            //��������middleValue���ʱ�����start����С��end�����Ƚϵ����ֵ�滻Ϊ�µ���ֵ���
	            src[end] = src[start];
	        }
	        //���ҵ��˷ֽ��󣬽��Ƚϵ���ֵ���н���������ֵ����start��end֮��ķֽ���ϣ����һ�ζ�ԭ����ֽ⣬��߶�С��middleValue���ұ߶�����middleValue
	        src[start] = middleValue;
	        return start;
	    }

	    /**
	     * ͨ���ݹ�ķ�ʽ����ԭʼ�������飬���п�������
	     *
	     * @param src �����������
	     * @param st ������������
	     * @param nd ������յ�����
	     */
	    public static void quickSort(Integer src[], int st, int nd){

	        if(st > nd){
	            return;
	        }
	        int middleIdx = middle(src, st, nd);
	        //���ָ����������߲��ֽ��п���
	        quickSort(src, st, middleIdx - 1);
	        //���ָ���������Ұ벿�ֽ��п���
	        quickSort(src, middleIdx + 1, nd);
	    }

	    /**
	     * ��ӡ���յ�������
	     *
	     * @param idx �������ı��
	     * @param B ���������
	     */
	    private static void printResult(int idx, int B[]){
	        System.out.print(idx + "--> ");
	        for(int i=0; i<B.length; i++){
	            System.out.print(B[i] + "  ");
	        }
	        System.out.println();
	    }
}
