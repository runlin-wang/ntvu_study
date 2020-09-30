package test4;

import test4.Circle;


	public class Circle {
		public int r;
		public int x;
		public int y;
		
		public int getR(){return r;}
		public void setR(int rr){ r=rr;}
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
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
				Circle1.setR(12);
				Circle2.r=22;
				System.out.println("Circle1 r="+Circle1.r+"中持="+Circle1.getArea());
				System.out.println("Circle2 r="+Circle2.r+"中持="+Circle2.getArea());
			}
			

	}

