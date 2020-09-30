package mydemo;

public class Test {
	public static void main(String[] args) {
		Circle a = new Circle();
		Circle b = new Circle();
		a.setR(10);
		b.setR(20);
		
		System.out.println(a.getR() + " are : " + a.getArea());
		System.out.println(b.getR() + " are : " + b.getArea());
	}
}
