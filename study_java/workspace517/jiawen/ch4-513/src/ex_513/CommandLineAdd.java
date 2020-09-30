package ex_513;

public class CommandLineAdd {
	  public static void main(String[] args)
	  {
		  if(args.length>0)
		  {
			  System.out.println("你输入的命令行参数是:");
			for(int i=0;i<args.length;i++)
			  {
				  System.out.println(args[i]);
			  }
		  } 
		  if(args.length==2)
		  {
			  int a=Integer.parseInt(args[0]);
			  int b=Integer.parseInt(args[1]);
			  System.out.println(a+b);
		  }
		  else
			  System.out.println("你输入的参数有误!");
	  }
}
