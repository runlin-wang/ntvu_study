// 例 6-4

package part_6;

class Array_string {
	public static void main(String[] args) {
		char c[] = {'J', 'a', 'v', 'a', ' ', 'i', 's', ' ','O', 'O', 'P'};
		String s1 = new String(c);
		String s2 = new String(s1);
		String s3 = new String();
		String s4 = new String("abc");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
}
