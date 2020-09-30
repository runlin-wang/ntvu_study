package shape;

public class Test {
	public static void main(String[] args) {
		Rectangle r = new Rectangle(8, 6);
		System.out.println(r.getArea());
		Square s = new Square(8);
		System.out.println(s.getArea());
		Ellipse e = new Ellipse(8, 6);
		System.out.println(e.getArea());
	}
}
