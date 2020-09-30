import java.util.Scanner;
public class Rect1513{
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("�����볤:");
		double chang=input.nextDouble();
		System.out.print("�������:");
		double kuan=input.nextDouble();
		double zhouchang=chang*2+kuan*2;
		double mianji=chang*kuan;
		System.out.println("�ܳ�:"+zhouchang+"���:"+mianji);
	}

}
