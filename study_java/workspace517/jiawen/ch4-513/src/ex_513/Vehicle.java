package ex_513;

public class Vehicle {
	private int speed;
	private int size;
	Vehicle(int a,int b){
		speed=a;
		size=b;
	}
	public void move(){}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void speedup(){
		speed++;
	}
	public void speedup(int speed){
		this.speed+=speed;
	}
	void speedDown(){
		speed--;
	}
	void speedDown(int speed){
		this.speed-=speed;
	}
	public String toString(){
		return"speed:"+speed+"size:"+size;
	}
	public static void main(String[] args){
		Vehicle v=new Vehicle(20,10);
		v.setSize(20);
		v.setSpeed(20);
		v.speedup(5);
		System.out.println(v);
		v.speedup();
		System.out.println(v);
		v.speedDown();
		System.out.println(v);
		v.speedDown(10);
		System.out.println(v);
	}
}