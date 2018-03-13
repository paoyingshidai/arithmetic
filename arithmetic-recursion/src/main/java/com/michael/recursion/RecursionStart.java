package com.michael.recursion;

public class RecursionStart {

//	1.递归求和1+2+3+.....+n

	public static Integer recursionSum(Integer n){
	   if(n>0){
	      return n+recursionSum(n-1);
	   }else{
	      return 0;
	   }
	}


//	2.递归阶乘n! = n * (n-1) * (n-2) * ...* 1(n>0)

	public static Integer recursionMulity(Integer n){
	   if(n==1){
	      return 1;
	   }
	   return n*recursionMulity(n-1);
	}

//	斐波那契算法  非常耗费性能
	 public static int Fribonacci(int n){
        if(n<=2)
            return 1;
        else
            return Fribonacci(n-1)+Fribonacci(n-2);

    }


	 public static void hanoiTower(int level, char from, char inner, char to) {
		 if (level ==1) {
			System.out.println("将 " + level + "号盘子从 " + from + " 移动到 " + to);
		} else {
			hanoiTower(level -1, from, to, inner);
			System.out.println("将 " + level + "号盘子从 " + from + " 移动到 " + to);
			hanoiTower(level -1, inner, from, to);
		}
	 }


	public static void main(String[] args) {
		System.out.println(recursionSum(4));
		System.out.println(recursionMulity(4));
		System.out.println(Fribonacci(40));
		hanoiTower(3, 'A', 'B', 'C');
	}

}
