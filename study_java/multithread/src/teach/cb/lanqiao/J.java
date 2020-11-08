package teach.cb.lanqiao; import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Calculator{
	private final char[] s;
	private final int start;
	private final int end;
	
	private boolean completed;
	private long count;
	
	public Calculator(char[] s, int start, int end) {
		this.s=s;
		this.start=start;
		this.end=end;
		this.count=0;
		this.completed=false;
	}
	
	public void Calculate(){
		int n=s.length;
		long curCount;
		int[] set =new int['z'+1];
		int i,j;
		for(i=start;i<end;i++){
			for(j=97;j<=122;j++)
				set[j]=0;
			curCount=0;
			for(j=i;j<n;j++){
				if(curCount==26){
					count+=26*(n-j);
					break;
				}
				if(set[s[j]]==0){
					set[s[j]]=1;
					curCount++;
				}
				count+=curCount;
			}
		}
		completed=true;
	}
	
	public boolean isCompleted(){
		return completed;
	}
	
	public long getCount(){
		return count;
	}
}

class CalculateThread extends Thread{
	Calculator target;
	
	public CalculateThread(Calculator target) {
		this.target=target;
	}
	
	@Override
	public void run() {
		target.Calculate();
	}
	
}

public class J {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		Scanner in=new Scanner(new File("data/data_10_0000.txt"));
		char[] s =in.next().toCharArray();
		in.close();
		int n=s.length;
		final int THREAD_COUNT=4;
		int[][] part =new int[][]{{0,n/10},{n/10,3*n/10},{3*n/10,6*n/10},{6*n/10,n}};
		
		Calculator[] c =new Calculator[THREAD_COUNT];
		CalculateThread[] ct =new CalculateThread[THREAD_COUNT];

//		long start = System.currentTimeMillis();
		for(int i=0;i<THREAD_COUNT;i++){
			c[i]=new Calculator(s, part[i][0], part[i][1]);
			ct[i]=new CalculateThread(c[i]);
			ct[i].start();
		}
		
		for(int i=0;i<THREAD_COUNT;i++)
			ct[i].join();

//		System.out.println(System.currentTimeMillis() - start);

		int count=0;
		for(int i=0;i<THREAD_COUNT;i++)
			count+=c[i].getCount();
		System.out.println(count);
	}

}
