package test;

public class CommandLine1 {
	public static void main (String[] args){
		if (args.length > 0)
		{
			System.out.println("您输入的命令性参数是: ");
			for (int i =0;i<args.length;i++)
			{
				System.out.println(args[i]);
			}
		}
	}
	

}
