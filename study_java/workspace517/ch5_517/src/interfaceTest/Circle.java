package interfaceTest;

public class Circle implements Ashape {
	public double originX; // 圆心
	public double originY;
	public double radius; // 半径

	public Circle() {
		originX = 0.0;
		originY = 0.0;
		radius = 1.0;
	}

	public Circle(double x, double y, double r) {
		originX = x;
		originY = y;
		radius = r;
	}

	public double getArea() { // 接口方法的实现，覆盖，求面积
		return radius * radius * PI;
	}

	public double getGirth() {
		return 2.0 * radius * PI;
	}
}
