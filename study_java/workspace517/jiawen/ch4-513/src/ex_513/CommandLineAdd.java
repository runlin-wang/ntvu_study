package ex_513;

public class CommandLineAdd {
	  public static void main(String[] args)
	  {
		  if(args.length>0)
		  {
			  System.out.println("������������в�����:");
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
			  System.out.println("������Ĳ�������!");
	  }
}
