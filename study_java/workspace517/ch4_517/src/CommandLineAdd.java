
public class CommandLineAdd {
	public static void main(String[] args) {
		int x, y;
		if (args.length == 2) {
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
			System.out.println("你输入的命令行参数是: "+x+"与"+y+" 它们的和为"+(x+y));
		}
		else
			System.out.println("你输入的命令行参数个数不对");
	}
}
