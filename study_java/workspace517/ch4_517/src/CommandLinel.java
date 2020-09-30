// 命令行参数
public class CommandLinel {
	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("你输入的命令行参数是:");
			for (int i = 0; i < args.length; i++)
				System.out.println(args[i]);
		}
	}
}
