package ex_517;

import java.util.Scanner;

class Rectangele {
	private int height; // 定义矩形的长
	private int width; // 定义矩形的宽

	Rectangele() {
	}

	Rectangele(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	} // 得到 和 修改 长

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	} // 得到 和 修改 宽

	public int getPerimeter() {
		return (height + width) * 2;
	} // 得到周长

	public int getArea() {
		return height * width;
	} // 得到面积

	void out() {
		System.out.println("长: " + height + " 宽 : " + width + " 周长: " + getPerimeter() + " 面积" + getArea());
	}

	public String toString() {
		return "长: " + height + " 宽 : " + width + " 周长: " + getPerimeter() + " 面积" + getArea();
	}
}

public class RectangeleTest {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int h, w;
		h = scanner.nextInt();
		w = scanner.nextInt();
		Rectangele a = new Rectangele(h, w);
		Rectangele b = new Rectangele(4, 6);
		System.out.println(a);
		b.out();
	}
}
