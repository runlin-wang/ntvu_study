package ex_513;
public class JZ_sum {
	public static void main(String args[]){
		int[][] randoms=new int[5][5];
		int sum1,sum2;
		for(int i=0;i<randoms.length;i++)
			for(int j=0;j<randoms[0].length;j++)
				randoms[i][j]=(int)(Math.random()*10);
		System. out. println("矩阵输出: ") ;
		for (int i=0;i <randoms.length;i++)
		{
		for (int j=0; j<randoms[0]. length; j++)
		System. out. print(randoms[i][j] +" ") ;
		System. out. println(" ");
		}
	System.out.println("转置输出: ");
	for(int j=0;j<randoms[0].length;j++){
		for(int i=0;i<randoms.length;i++)
			System.out.print(randoms[i][j]+" ");
    System.out.println("  ");
	}
	System.out.println("对角线输出: ");
	for(int i=0;i<randoms.length;i++)
		System.out.print(randoms[i][i]+" ");
    System.out.println("    ");
	for(int i=0;i<randoms.length;i++)
		System.out.print(randoms[i][4-i]+" ");
    System.out.println("    ");
    System.out.println("输出各行的和:");
	for(int i=0;i<randoms[0].length;i++){
		sum1=0;
		for(int j=0;j<randoms[0].length;j++)
			sum1+=randoms[i][j];
	    System.out.println(sum1+"  ");
	}
    System.out.println("输出各列的和:");
	for(int i=0;i<randoms.length;i++){
		sum2=0;
		for(int j=0;j<randoms[0].length;j++)
			sum2+=randoms[j][i];
	    System.out.println(sum2+"  ");
	  }
	}
}
