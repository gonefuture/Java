package 决赛2014.格子放鸡蛋;
/**
X星球的母鸡很聪明。它们把蛋直接下在一个 N * N 的格子中，每个格子只能容纳一枚鸡蛋。它们有个习惯，要求：每行，每列，以及每个斜线上都不能有超过2个鸡蛋。如果要满足这些要求，母鸡最多能下多少蛋呢，有多少种摆放方法呢？
 

    下面的程序解决了这个问题，请仔细分析程序逻辑，推断划线处缺少的代码。
 */

public class Main {
	static int max = 0;
	static int T = 0;
	static final int N = 6;
		
	// 只能在(r,c) 以及其右，其下放置 
	static void f(int[][] da, int r, int c)
	{	
		if(r>=N){
			int n = count(da);
			if(n>max) {
				max = n;
				T = 0;
			}
			if(n==max) T++;
			return;
		}
		
		//计算一下步放哪
		int r_next = r;
		int c_next = c + 1;
		if(c_next>=N){
			c_next = 0;
			r_next++;
		}
		
		if(____________________){  // 填空位置
			da[r][c] = 1;
			f(da, r_next, c_next); 
		}
		
		da[r][c] = 0;
		f(da, r_next, c_next);
	}
	
	static int count(int[][] da)
	{
		int n = 0;
		
		for(int i=0; i<da.length; i++)
		for(int j=0; j<da[i].length; j++) 
			if(da[i][j]==1) n++;
			
		return n;
	}
	
	static int spy(int[][] da, int r, int c)
	{
		int m=0;
		
		// 该行
		int n=0;
		for(int i=0; i<N; i++) if(da[r][i]==1) n++;
		if(n>m) m = n;

		//该列
		n=0;
		for(int i=0; i<N; i++) if(da[i][c]==1) n++;
		if(n>m) m = n;
		
		//右斜线
		n=0;
		for(int i=0; i<N; i++){ 
			if(r-i<0 || c-i<0) break; 
			if(da[r-i][c-i]==1) n++;
		}
		for(int i=1; i<N; i++){ 
			if(r+i>=N || c+i>=N) break; 
			if(da[r+i][c+i]==1) n++;
		}
		if(n>m) m = n;
		
		//左斜线
		n=0;
		for(int i=0; i<N; i++){ 
			if(r-i<0 || c+i>=N) break; 
			if(da[r-i][c+i]==1) n++;
		}
		for(int i=1; i<N; i++){ 
			if(r+i>=N || c-i<0) break; 
			if(da[r+i][c-i]==1) n++;
		}
		if(n > m) m = n;
		
		return m;
	}
	
	public static void main(String[] args)
	{
		int[][] da = new int[N][N];
		
		f(da, 0, 0);
		
		System.out.println(max);
		System.out.println(T);
	}

}
/*****
 *

public class A
{
	
 
 */
