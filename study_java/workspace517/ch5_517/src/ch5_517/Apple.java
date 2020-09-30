package ch5_517;

class Fruit {
	public String fruitName;
	public double weight;
	public void info() {
		System.out.println("我是一个 " + fruitName + "~重" + weight + "g");
	}
}

public class Apple extends Fruit {
	Apple a = new Apple();
//	a.fruitName = "苹果";
//	a.weight = 200;
}
