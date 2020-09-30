package shape;

public class Ellipse extends Shape {
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
