import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {
	
	 public static void main(String[] args) {
	        ExecutorService executor = Executors.newFixedThreadPool(5);
	        for (int i = 0; i < 10; i++) {
	            Runnable worker = new WorkerThread(" " + i);
	            executor.execute(worker);
	          }
	        
	        //previously submitted tasks will be executed but no new tasks will be accepted;
	        executor.shutdown();
	        //
	        while (!executor.isTerminated()) {
	        }
	        System.out.println("Finished all threads");
	}
}