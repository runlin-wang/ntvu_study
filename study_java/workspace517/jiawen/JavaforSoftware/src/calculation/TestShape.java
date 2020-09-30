package calculation;


public class TestShape {
	public static void main (String[] args)
	{
	Circle circle1=new Circle();
	circle1. setName ("circle1") ;
	circle1. setArea(4) ;
	circle1.setGirth(4) ;
	System. out. println (circle1.getName () +"\n"+"周长: "+circle1 .getArea () +"\n"+"面积: "+circle1.getGirth());
	System. out.println();
	Rectangle rectangle1=new Rectangle() ;
	rectangle1. setName ("rectangle1") ;
	rectangle1.setArea(5,6) ;
	rectangle1 .setGirth(5,6);
	System. out. println (rectangle1. getName () +"\n"+"周长: "+rectangle1.getArea()+"\n"+"面积: "+rectangle1.getGirth());
	}


}