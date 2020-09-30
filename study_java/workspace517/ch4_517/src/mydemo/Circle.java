package mydemo;

public class Circle {
	private int r;
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public double getArea() {
		return Math.PI*r*r;
	}
}
