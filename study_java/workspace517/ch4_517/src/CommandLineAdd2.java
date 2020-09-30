
public class CommandLineAdd2 {
	public static void main(String[] args) {
		int i, sum = 0; 
		int a[] = new int[100];
		if (args.length > 0) {
			for (i = 0; i < args.length; i++) {
				a[i] = Integer.parseInt(args[i]);
				sum += a[i];
			}
			System.out.println("输入的数的个数为 " + i + " 它们的和为" + sum);
			System.out.println("它们分别是");
			for (i = 0; i < args.length; i++)
				System.out.println(a[i]);
		}
		else
			System.out.println("输入错误");
	}
}
