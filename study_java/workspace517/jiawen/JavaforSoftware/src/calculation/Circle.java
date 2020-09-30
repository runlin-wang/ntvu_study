package calculation;


public class Circle extends Shape {
	String name;
	double radius=3;
	double area;
	double girth;
	public String getName ()
	{
		return name ;
	}
	public void setName (String name )
	{
		this. name=name ;
	}
	public double getArea()
	{
		return area;
	}
	public void setArea (double radius)
	{
		this. area=radius*radius*3.14159;
	}
	public double getGirth ()
	{
		return girth;
	}
	public void setGirth (double radius)
	{
		this. girth=radius*2*3.14159;
	}
}