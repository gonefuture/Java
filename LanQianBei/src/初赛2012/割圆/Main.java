package 初赛2012.割圆;

public class Main {
	public static void main(String[] args)
	{
		System.out.println("标准 " + Math.PI);
		
		double a = 1; 
		int n = 6;
		
		for(int i=0; i<10; i++)
		{
			double b = Math.sqrt(1-(a/2)*(a/2));
			a = Math.sqrt((1-b)*(1-b) + (a/2)*(a/2));
			
			n = 2*n; //填空
			
			System.out.println(n + "  " + a*n/2);  // 填空
		}
	}
}
 /***
    南北朝时，我国数学家祖冲之首先把圆周率值计算到小数点后六位，比欧洲早了1100年！他采用的是称为“割圆法”的算法，实际上已经蕴含着现代微积分的思想。

    如图【1.jpg】所示，圆的内接正六边形周长与圆的周长近似。多边形的边越多，接近的越好！我们从正六边形开始割圆吧。

    如图【2.jpg】所示，从圆心做弦的垂线，可把6边形分割为12边形。该12边形的边长a'的计算方法很容易利用勾股定理给出。之后，再分割为正24边形，....如此循环会越来越接近圆周。

    之所以从正六边开始，是因为此时边长与半径相等，便于计算。取半径值为1，开始割圆吧！

    以下代码描述了割圆过程。
    
    程序先输出了标准圆周率值，紧接着输出了不断分割过程中多边形边数和所对应的圆周率逼近值。

public class B21
{
	public static void main(String[] args)
	{
		System.out.println("标准 " + Math.PI);
		
		double a = 1; 
		int n = 6;
		
		for(int i=0; i<10; i++)
		{
			double b = Math.sqrt(1-(a/2)*(a/2));
			a = Math.sqrt((1-b)*(1-b) + (a/2)*(a/2));
			
			n = ______________; //填空
			
			System.out.println(n + "  " + _______________);  // 填空
		}
	}
}
***/