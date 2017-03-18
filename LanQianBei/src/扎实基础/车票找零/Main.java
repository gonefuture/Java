package 扎实基础.车票找零;
	/**
	 公交车票价为5角。假设每位乘客只持有两种币值的货币：5角、1元。再假设持有5角的乘客有m人，持有1元的乘客有n人。
	 由于特殊情况，开始的时候，售票员没有零钱可找。我们想知道这m+n名乘客以什么样的顺序购票则可以顺利完成购票过程。
	 显然，m < n的时候，无论如何都不能完成，m >=n的时候，有些情况也不行。比如，第一个购票的乘客就持有1元。
	 下面的程序计算出这m+n名乘客所有可能顺利完成购票的不同情况的组合数目。
	 注意：只关心5角和1元交替出现的次序的不同排列，持有同样币值的两名乘客交换位置并不算做一种新的情况来计数。
	m: 持有5角币的人数
	n: 持有1元币的人数
	返回：所有顺利完成购票过程的购票次序的种类数
int f(int m, int n)
{
	if(m < n) return 0;
	if(n==0) return 1;
	return _______________________;
}
	 */
public class Main {
	public static void main(String[] args){
		System.out.println(f(3,3));
	}
	
	/**
	 * 注意递归调用
	 */
	public static int f(int m,int n){
		if(m < n) return 0;
		if(n == 0) return 1;
		return  f(m-1,n)+f(m,n-1);
	}

}
