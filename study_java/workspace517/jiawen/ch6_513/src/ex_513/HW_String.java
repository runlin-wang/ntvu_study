package ex_513;
import java.util.Scanner;
public class HW_String 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("�������ַ���");
		String s=sc.next();
		for(int i=0;i<s.length();i++)
		{
			if(i==s.length()-1)
			{
				System.out.println("�ǻ����ַ���");
			}
			else if(s.charAt(i)==s.charAt(s.length()-i-1))
			{
				continue;
			}
			else
			{
				System.out.println("���ǻ����ַ���");
				break;
			}
		}	
	}
}