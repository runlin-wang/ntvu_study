package ex_513;
import java.util.Scanner;


public class RectangleDemo{
	private double length;
	private double width;
	
	RectangleDemo()
	{}
	
	RectangleDemo(double l,double w)
	{
		length=l;
		width=w;
		
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length)throws Exception {
		if(length>0){
			this.length = length;
		}
		else{
			throw new Exception("error,长度应该大于0");
		}
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) throws Exception {
		if(width>0){
		this.width = width;
		}
		else{
			throw new Exception("error,宽度应该大于0");
	
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
		RectangleDemo rectangle1=new RectangleDemo();
		int l,w;
		Scanner input=new Scanner(System.in);
		try{
		System.out.println("请输入长：");
		l=input.nextInt();
		System.out.println("请输入宽：");
		w=input.nextInt();
		rectangle1.setLength(l);
		rectangle1.setWidth(w);
		System.out.println("第一个长方形：");
		rectangle1.out();
		RectangleDemo rectangle2=new RectangleDemo(l,w);
		System.out.println("第二个长方形：");
		rectangle2.out();
	}
	catch (Exception e){
		e.printStackTrace();
	}
	
	}
}
