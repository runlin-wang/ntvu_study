// 例6-7
package part_6;

public class Replace {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Java programming!");
		System.out.println(sb);
		sb.replace(0, 4, "This is C");
		System.out.println(sb);
	}
}
