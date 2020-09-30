public class P75_8513 {
	public static void main (String args []){
		int i=1;
		double e=1.0,d=1.0;
		while (1/d>=1e-6)
		{
			d=i*d;
			e=1.0/d+e;
			i++;
		}
	
		System.out.println("e="+e);
	}

}