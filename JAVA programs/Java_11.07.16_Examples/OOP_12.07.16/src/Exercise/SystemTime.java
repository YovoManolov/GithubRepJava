package Exercise;

public class SystemTime {

	public static void main(String[] args) {
		int sum = 0;
		long startTime = System.currentTimeMillis();
		// The code fragment to be tested
		
		for(int i = 0; i < 10000000; i = i+5 /2) {
		sum++;
		}
		
		long endTime = System.currentTimeMillis();
		System.out.printf("The time elapsed is %f sec \n",((endTime - startTime)/1000.0));
		System.out.printf("The sum is %d ",sum);
	}	
}