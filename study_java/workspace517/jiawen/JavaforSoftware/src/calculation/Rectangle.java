package calculation;


public class Rectangle extends Shape {
	String name;
	double length;
	double width;
	double area;
	double girth;
	public String getName ()
	{
	    return name;
	}
	public void setName (String name)
	{
		this. name=name;
	}
	public double getArea() 
	{
		return area;
	}
	public void setArea (double length, double width)
	{
		this. area=length*width;
	}
	public double getGirth()
	{
		return girth;
	}
	public void setGirth (double length, double width)
	{
		this. girth=length* 2+width*2;
	}
}
