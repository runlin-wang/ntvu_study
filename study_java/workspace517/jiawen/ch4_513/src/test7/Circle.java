package test7;

import test7.Circle;

public class Circle {
	public int r;
	public int x;
	public int y;
	public double getArea(){
		return 3.14159*r*r;}
	Circle(int r)
	{
		this.r=r;
	}
	Circle()
	{
	
	}
		
		
		public static void main(String args[])
		{
			Circle Circle1=new Circle();
			Circle Circle2=new Circle(20);
			Circle1.r=10;
			Circle2.r=20;
			System.out.println("Circle1 r="+Circle1.r+"���="+Circle1.getArea());
			System.out.println("Circle2 r="+Circle2.r+"���="+Circle2.getArea());
		
		}
}
