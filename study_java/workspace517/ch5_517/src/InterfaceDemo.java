
interface AShape {
	double PI = 3.1415926;

	double getArea();

	double getGirth();
}

class Circle implements AShape {
	public double originX;
	public double originY;
	public double radius;

	public Circle(double x, double y, double r) {
		this.originX = x;
		this.originY = y;
		this.radius = r;
	}

	public double getArea() {
		return PI * radius * radius;
	}

	public double getGirth() {
		return 2 * PI * radius;
	}
}

class Rectangle implements AShape {
	public double length;
	public double height;

	public Rectangle() {
	}

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

public class InterfaceDemo {
	public static void main(String args[]) {
		Circle c = new Circle(0, 0, 1);
		Rectangle r = new Rectangle(4, 6);
		System.out.println("圆的面积为" + c.getArea());
		System.out.println("圆的周长为" + c.getGirth());
		System.out.println("矩形的面积为" + r.getArea());
		System.out.println("矩形的周长为" + r.getGirth());
	}
}