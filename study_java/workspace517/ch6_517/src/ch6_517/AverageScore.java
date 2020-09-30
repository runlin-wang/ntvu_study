package ch6_517;

public class AverageScore {
	public static void main(String[] args) {
		int[] score = {72,89,65,58,87,91,53,82,71,93,76,68};
		
		float average = 0.0f;
		for (int i = 0; i < score.length; i++) {
			average += score[i];
		}
		average /= score.length;
		System.out.println(average);
	}
}
