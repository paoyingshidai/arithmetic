package com.michael.sort.my;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Count {

    public  static void charcount(String str) {
        int count = 0;
        Map<String, Integer> map = new HashMap();
        char arr[] = str.toCharArray();
        int n=str.length();
        for(int i = 0; i < n; i++) {
            count = str.length() - str.replace(arr[i] + "", "").length();
            str = str.replace(arr[i] + "","" );
            map.put(arr[i] + "", count);
            arr = str.toCharArray();
            n = arr.length;
            i = -1;
        }
        System.out.println(map.toString());
    }


    public static void count2(String str) {

        char[] chars = str.toCharArray();
        Map<String, AtomicInteger> map = new HashMap<>(32);
        for (char aChar : chars) {
            AtomicInteger count = map.get(aChar+"");
            if (count == null) {
                count = new AtomicInteger(1);
                map.put(aChar+"", count);
            } else {
                count.getAndAdd(1);
            }
        }
        System.out.println(map);
    }


    public static void main(String[] args) {
        String a = "aaaBBBsadfasfetasdfsdfsaaaaaaaaaaaaaA23";
//        charcount(a);
        count2(a);
    }

}
