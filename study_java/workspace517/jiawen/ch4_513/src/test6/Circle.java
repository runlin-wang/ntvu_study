package test6;

import test6.Circle;


	public class Circle {
		final float PI=3.14f;
		static int c;
		public int r;
		public int x=0;
		public int y=0;
		public double getArea(){
			return PI*r*r;}
			
			
			public static void main(String args[])
			{
				Circle Circle1=new Circle();
				Circle Circle2=new Circle();
				Circle1.r=10;
				Circle1.x=10;
				Circle1.y=10;
				Circle1.c=10;
				System.out.println("Circle1 r="+Circle1.r+"中持="+Circle1.getArea());
				System.out.println("Circle1 c="+Circle1.c);
				System.out.println("Circle2 c="+Circle2.c);
				System.out.println("Circle2 x="+Circle2.x);
				Circle2.c=20;
				Circle2.r=20;
				System.out.println("Circle2 r="+Circle2.r+"中持="+Circle2.getArea());
				System.out.println("Circle1 c="+Circle1.c);
				System.out.println("Circle2 c="+Circle2.c);
				
				Circle.c=30;
				System.out.println("Circle1 c="+Circle1.c);
				System.out.println("Circle1 r="+Circle1.c);
				System.out.println("Circle2 r="+Circle2.c);}
				
				
			


}
