package ex_513;

public class Interface {
	public static void main (String[] argsument)
	{
		Circle r= new Circle(10,10,8);
		System.out.println("圆的面积为："+r.getArea());
		System.out.println("圆的周长为："+r.getGirth());
		Rectangle1 rr=new Rectangle1 (10,8);
		System.out.println("长方形的面积为："+rr.getArea());
		System.out.println("长方形的周长为："+rr.getGirth());
	}
}
interface AShape
   {
	double PI=3.14159;
	double getArea();
	double getGirth();
   }
class Circle implements AShape
{
	 public double originX;
	 public double originY;
	 public double radius;
public Circle()
{
	originX=0.0;
	originY=0.0;
	radius=1.0;
}
public Circle (double x,double y,double r)
   {
	originX=x;
	originY=y;
	radius=r;
   }
public double getArea()
   {
	return radius*radius*PI;
   }
public double getGirth()
   {
	return 2.0*radius*PI;
   }
}
   class Rectangle1 implements AShape
   {
 	 public double YC;
 	 public double YK;	 
    public Rectangle1()
   {
 	YC=0.0;
 	YK=0.0;
   }
     public Rectangle1 (double x ,double y){
	 YC = x;
	 YK = y;
      }
    public double getArea(){
	 return YC*YK;
    }
        public double getGirth(){
	 return 2.0*(YC*YK);
    }

}
