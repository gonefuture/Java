package 决赛2012.提取子串;

public class Main {
	public static void main(String[] args) {
		System.out.println(getMaxMirrorString("abcba"));
	}
	
	public static String getMaxMirrorString(String s)
	{
		String max_s = "";  // 所求的最大对称子串

		for(int i=0; i<s.length(); i++)
		{
			// 第一种对称模式
			int step = 1;
			try{
				for(;;)
				{
					if(s.charAt(i-step) != s.charAt(i+step)) break;
					step++;
				}
			}catch(Exception e){}
			
			String s1 = s.substring(i,s.length()-i);     // 填空1
			
			
			// 第二种对称模式
			step = 0;
			try{
				for(;;)
				{
					if(s.charAt(i-step) != s.charAt(s.length()+step-i)) break;    // 填空2
					step++;
				}
			}catch(Exception e){}
			
			String s2 = s.substring(i-step+1,i+step+1);
			
			
			if(s1.length() > max_s.length()) max_s = s1;
			if(s2.length() > max_s.length()) max_s = s2;
		}
		
		return max_s;				
	}
	 
}
		/****
		 *串“abcba”以字母“c”为中心左右对称；串“abba” 是另一种模式的左右对称。这两种情况我们都称这个串是镜像串。特别地，只含有1个字母的串，可以看成是第一种模式的镜像串。 

    一个串可以含有许多镜像子串。我们的目标是求一个串的最大镜像子串（最长的镜像子串），如果有多个最大镜像子串，对称中心靠左的优先选中。例如：“abcdeefghhgfeiieje444k444lmn”的最大镜像子串是：“efghhgfe”

    下面的静态方法实现了该功能，请仔细阅读并分析代码，填写空白处的代码，使得程序的逻辑合理，结果正确。

// 求最大(长度最大)镜像对称子串
public static String getMaxMirrorString(String s)
{
	String max_s = "";  // 所求的最大对称子串

	for(int i=0; i<s.length(); i++)
	{
		// 第一种对称模式
		int step = 1;
		try{
			for(;;)
			{
				if(s.charAt(i-step) != s.charAt(i+step)) break;
				step++;
			}
		}catch(Exception e){}
		
		String s1 = s.substring(_____________________________);     // 填空1
		
		
		// 第二种对称模式
		step = 0;
		try{
			for(;;)
			{
				if(_________________________________) break;    // 填空2
				step++;
			}
		}catch(Exception e){}
		
		String s2 = s.substring(i-step+1,i+step+1);
		
		
		if(s1.length() > max_s.length()) max_s = s1;
		if(s2.length() > max_s.length()) max_s = s2;
	}
	
	return max_s;				
}
 
		 */
		