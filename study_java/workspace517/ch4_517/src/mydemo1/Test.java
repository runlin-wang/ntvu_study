package mydemo1;

class Circle {
	private int r;
	private int x;
	private int y;
	
	public double getArea() {
		return Math.PI*r*r;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

public class Test {
	public static void main(String[] args) {
		Circle a = new Circle();
		Circle b = new Circle();
		
		a.setR(10);
		a.setX(1);
		a.setY(1);
		b.setR(20);
		b.setX(2);
		b.setY(2);
		
		System.out.println("a are : " + a.getArea());
		System.out.println("b are : " + b.getArea());
	}
}
