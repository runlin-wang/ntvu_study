package ch10_517;

public class RectangleDemo {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(-1, 5);
		Rectangle rect2 = new Rectangle(1, 6);

		try {
			if (rect1.getLength() <= 0 || rect1.getHeight() <= 0)
				throw new Exception();

			System.out.println("rect1: " + rect1.toString());
		} catch (Exception e) {
			System.out.println("程序出现异常，矩形的长和宽不能小于0");
		}

		try {
			if (rect2.getLength() <= 0 || rect2.getHeight() <= 0)
				throw new Exception();

			System.out.println("rect2: " + rect2.toString());
		} catch (Exception e) {
			System.out.println("程序出现异常，矩形的长和宽不能小于等于0");
		}

	}
}

class Rectangle {
	private double length;
	private double height;

	public Rectangle(double length, double height) {
		this.length = length;
		this.height = height;
	}

	public Rectangle() {
	}

	public double getLength() {
		return length;
	}

	public double getHeight() {
		return height;
	}

	public double getArea() {
		return length * height;
	}

	public double getGirth() {
		return 2.0 * (length + height);
	}

	public String toString() {
		return "Area: " + length * height + " Girth: " + 2.0 * (length + height);
	}
}
