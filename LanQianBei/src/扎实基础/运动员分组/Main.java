package 扎实基础.运动员分组;

import java.util.Scanner;

/**
有N个人参加100米短跑比赛。跑道为8条。程序的任务是按照尽量使每组的人数相差最少的原则分组。
例如：
N=8时，分成1组即可。
N=9时，分成2组：一组5人，一组4人。
N=25时，分4组：7、6、6、6。
请编程计算分组数字。要求从键盘输入一个正整数（1~100之间，不必考虑输入错误的情况），表示参赛的人数。程序输出每个组的人数。从大到小顺序输出，每个数字一行。
比如，用户输入：25
程序输出：
7
6
6
6
------------------------------
int g = n / 8;
if(n%8>0) g++;

g = (n+7)/8;

double x = 45.56;
   (int)(x+0.5);
 */
public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int g = n / 8;
		int x = n/g;
		if (n%8 > 0) {
			g++;
			System.out.println(x+(n%8));
		}
		
		
		for (int i=g;i>0;i--) {
			System.out .println(x);
		}
		sc.close();
		
	}
	
	
}

