package numGame;

import java.util.Random;

public class A {
	Random a = new Random();
	int v = a.nextInt(100);

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}
}
