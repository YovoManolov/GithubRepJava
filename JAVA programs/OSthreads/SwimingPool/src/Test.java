import java.util.concurrent.Semaphore;

public class Test {

	public static Semaphore semaphore = new Semaphore(1);
	public static int waterInPool = 0;
	public static int maxPoolCapacity = 3000;
	public static int minPoolCapacity = 0;
	
	public static void main(String[] args)
	{	
		Thread pipe1 = new Thread(new Pipe(1,10,50));
		Thread pipe2 = new Thread(new Pipe(2,-70,1000));
		Thread pipe3 = new Thread(new Pipe(3,-300,4500));
		
		pipe1.start();
		pipe2.start();
		pipe3.start();
	}
}
