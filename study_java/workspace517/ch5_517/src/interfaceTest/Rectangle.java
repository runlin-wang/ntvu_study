package interfaceTest;

public class Rectangle implements Ashape {
	public double length;
	public double height;

	public Rectangle() {}

	public Rectangle(double length, double height) {
		this.length = length;
		this.height = height;
	}

	public double getArea() {
		return length * height;
	}

	public double getGirth() {
		return (length + height) * 2;
	}
}
