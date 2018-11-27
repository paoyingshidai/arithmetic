package com.michael.recursion;

public class MathProblem {


    public static void hannuota(String a, String b, String c, int level) {

        if (level == 1) {
            System.out.println(a + " ----> " + b);
        } else {
            hannuota(a, c, b, level - 1);
            System.out.println(a + " ----> " + b);
            hannuota(c, b, a, level - 1);
        }
    }


    public static Integer fabonaqi(Integer n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (n > 1) {
            return fabonaqi(n - 1) + fabonaqi(n - 2);
        } else {
            return 0;
        }
    }


    /**
     * 1, 12, 123, 1234, 12345 ...
     * https://www.cnblogs.com/chengjun/p/5383775.html
     */
    public static Integer get(Integer num) {

        if (num == 1) {
            return 1;
        }
        if (num > 1) {
            return get(num - 1) * 10 + num;
        } else {
            return 0;
        }
    }


    /**
     * 123456789 --> 987654321
     * 不允许使用内置函数
     * @param n
     * @return
     */
    public static Integer resort(Integer n) {

        Integer temp = new Integer(n);
        Integer level = 0;
        Integer div = n / 10;  // 除以十的结果
        Integer lef = n % 10;  // 余数

        // 判断当前的位数
        while (temp / 10 != 0) {
            level ++;
            temp = temp / 10;
        }

        if (div == 0) {
            return lef;
        }
        if (div > 0) {
            int in = 1;
            while(level != 0) {
                in = in * 10;
                level--;
            }

            return  in * lef + resort(div);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

//        hannuota("A", "B", "C", 10);

//        System.out.println(fabonaqi(13));

//        System.out.println(get(9));

        System.out.println(resort(987654321));
    }
}




