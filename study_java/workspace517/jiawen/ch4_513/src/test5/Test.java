package test5;


class Circle {
	private int r;
	private int x;
	private int y;
	
	public int getR() {return r;}//get意为得到
	public void setR(int rr) {   r=rr;  }//set意为设置
	public int getX() {return x;}
	public void setX(int x) {  this.x = x;  }
	public int getY() {return y;}
	public void setY(int y) {  this.y = y;  }
	
	public double getArea(){  return 3.1415926*r*r;}
}

public class Test {
	public static void main(String args[])//main()方法
	{
		Circle Circle1 = new Circle();
		Circle Circle2 = new Circle();
		Circle1.setR(12);
		Circle2.setR(22);
		System.out.println("Circle1 r="+Circle1.getR()+"面积="+Circle1.getArea());
		
		System.out.println("Circle2 r="+Circle2.getR()+"面积="+Circle2.getArea());
	}
}