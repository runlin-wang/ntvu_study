package ex_513;

import java.util.Scanner;
public class Rectangle{
	private double length;
	private double width;
	Rectangle()
	{}
	Rectangle(double l,double w)
	{
		length=l;
		width=w;	
	}
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if(length>0){
			this.length = length;
		}
		else{
			System.out.println("error,����Ӧ�ô���0");
			System.exit(0);
		}
	}
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if(width>0){
		this.width = width;
		}
		else{
			System.out.println("error,���Ӧ�ô���0");
			System.exit(0);
		}
	}
	public double area(){
		return length*width;
	}
	public void out(){
		System.out.println("length:"+length);
		System.out.println("width:"+width);
		System.out.println("area:"+this.area());
	}
	public static void main(String[] args){
		Rectangle rectangle1=new Rectangle();
		int l,w;
		Scanner input=new Scanner(System.in);
		System.out.println("�����볤��");
		l=input.nextInt();
		System.out.println("�������");
		w=input.nextInt();
		rectangle1.setLength(l);
		rectangle1.setWidth(w);
		System.out.println("��һ�������Σ�");
		rectangle1.out();
		System.out.println("�����볤��");
		l=input.nextInt();
		System.out.println("�������");
		w=input.nextInt();
		Rectangle rectangle2=new Rectangle(l,w);
		System.out.println("�ڶ��������Σ�");
		rectangle2.out();
	}
}