package interfaceTest;

public class Test {
	public static void main(String[] args) {
		Circle c = new Circle(5, 5, 5);
		System.out.println(c.getArea() + "  " + c.getGirth());
		Rectangle r = new Rectangle(3, 4);
		System.out.println(r.getArea() + "  " + r.getGirth());
	}
}
