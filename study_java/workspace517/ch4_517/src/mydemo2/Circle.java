package mydemo2;

public class Circle {
	private int r;
	private int x;
	private int y;
	
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

	public double getArea() {
		return Math.PI*r*r;
	}
	
	public static void main(String[] args) {
		Circle aCircle = new Circle();
		Circle bCircle = new Circle();
		aCircle.setR(10);
		aCircle.setX(1);
		aCircle.setY(1);
		bCircle.setR(20);
		bCircle.setX(2);
		bCircle.setY(2);
		
		System.out.println("面积是 " + aCircle.getR());
		System.out.println("aCircle are : " + aCircle.getArea());
		System.out.println("bCircle are : " + bCircle.getArea());
	}
}