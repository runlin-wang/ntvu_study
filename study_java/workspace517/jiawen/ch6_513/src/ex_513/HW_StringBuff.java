package ex_513;
import java.util.Scanner;
public class HW_StringBuff 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("�������ַ���");
		String s=sc.next();
		StringBuffer sb=new StringBuffer(s);
		sb.reverse();
		if(s.equals(sb.toString())){
			System.out.println("�ǻ����ַ���");
		}else{
			System.out.println("���ǻ����ַ���");}
	}
}