package shape;

public class Rectangle {
	private double length;
	private double height;

	public Rectangle(double length, double height) {
		this.length = length;
		this.height = height;
	}

	public Rectangle() {
	}

	public double getArea() {
		return length * height;
	}
}
