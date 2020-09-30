package test2;

import test1.Circle;

 class Test {
	public int r;
	public int x;
	public int y;
	public double getArea(){
		return 3.14159*r*r;}
		
		
		public static void main(String[] args)
		{
			Circle Circle1=new Circle();
			Circle Circle2=new Circle();
			Circle1.r=10;
			Circle2.r=20;
			System.out.println("Circle1 r="+Circle1.r+"中持="+Circle1.getArea());
			System.out.println("Circle2 r="+Circle2.r+"中持="+Circle2.getArea());
		}
}
