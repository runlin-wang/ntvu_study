
abstract class Shape {
	public abstract double getArea();
}

class Rect extends Shape {
	private double length;
	private double height;

	public Rect(double length, double height) {
		this.height = height;
		this.length = length;
	}

	public double getArea() {
		return length * height;
	}
}

class Square extends Rect {
	public Square(double length) {
		super(length, length);
	}
}

class Ellipse extends Shape {
	private double majorAxis;
	private double minorAxis;

	public Ellipse(double majorAxis, double minorAxis) {
		this.majorAxis = majorAxis;
		this.minorAxis = minorAxis;
	}

	public double getArea() {
		return Math.PI * majorAxis / 2.0 * minorAxis / 2.0;
	}
}

public class AbstractDemo {
	public static void main(String args[]) {
		Rect r = new Rect(8, 6);
		Square s = new Square(8);
		Ellipse e = new Ellipse(8, 6);

		System.out.println(r.getArea());
		System.out.println(s.getArea());
		System.out.println(e.getArea());
	}
}