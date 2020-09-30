package ex_517;

public class Vehicle {
	private int speed; // 速度 <km/h>
	private int size; // 体积 <m^3>

	Vehicle() {
	}

	Vehicle(int speed, int size) {
		this.speed = speed;
		this.size = size;
	}

	public int move(int time) {
		return speed * time;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void speedUp(int speed) {
		this.speed += speed;
	}

	public void speedDown(int speed) {
		this.speed -= speed;
	}

	void out() {
		System.out.printf("speed = %d km/h\n", speed);
	}

	public String toString() {
		return "speed = " + speed + " km/h  size = " + size;
	}

	public static void main(String[] args) {
		int time = 4;
		Vehicle a = new Vehicle(80, 20);
		System.out.println(a);
		System.out.printf("Move = %d km\n", a.move(time));
		a.speedUp(20);
		System.out.println(a);
		System.out.printf("Move = %d km\n", a.move(time));
		a.speedDown(40);
		System.out.println(a);
		System.out.printf("Move = %d km\n", a.move(time));
	}
}
