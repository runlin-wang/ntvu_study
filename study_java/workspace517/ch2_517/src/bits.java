
public class bits {
	static int a = 0xaa;
	static int b = 0x77;
	public static void main(String[] args) {
		
		System.out.println("a&b = " + Integer.toHexString(a&b));
		System.out.println("a|b = " + Integer.toHexString(a|b));
		System.out.println("a^b = " + Integer.toHexString(a^b));
		System.out.println("~a = " + Integer.toHexString(~a));
	}
}
