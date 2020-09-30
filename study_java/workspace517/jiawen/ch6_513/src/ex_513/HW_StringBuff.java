package ex_513;
import java.util.Scanner;
public class HW_StringBuff 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入字符串");
		String s=sc.next();
		StringBuffer sb=new StringBuffer(s);
		sb.reverse();
		if(s.equals(sb.toString())){
			System.out.println("是回文字符串");
		}else{
			System.out.println("不是回文字符串");}
	}
}