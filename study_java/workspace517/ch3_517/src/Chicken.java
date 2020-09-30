
public class Chicken {
	public static void main(String[] args) {
		int hen, cock, chick;
		for (hen = 0; hen <= 20; hen++) {
			for (cock = 0; cock < 34; cock++) {
				chick = 100 - hen - cock; 
				if (chick % 3 == 0 && 5 * hen + 3 * cock + chick / 3 == 100 && hen + cock + chick == 100) 
					System.out.printf(" hen = %d  cock = %d  chick = %d \n", hen, cock, chick);
			}
		}
	}
}
