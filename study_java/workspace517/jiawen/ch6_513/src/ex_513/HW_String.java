package ex_513;
import java.util.Scanner;
public class HW_String 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入字符串");
		String s=sc.next();
		for(int i=0;i<s.length();i++)
		{
			if(i==s.length()-1)
			{
				System.out.println("是回文字符串");
			}
			else if(s.charAt(i)==s.charAt(s.length()-i-1))
			{
				continue;
			}
			else
			{
				System.out.println("不是回文字符串");
				break;
			}
		}	
	}
}