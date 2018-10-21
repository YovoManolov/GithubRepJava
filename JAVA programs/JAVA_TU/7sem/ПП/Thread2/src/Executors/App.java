package Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*1.ExecutorService executorService=Executor.newCachedThreadPool();
  - going to return an executorService  that can dynamically reuse threads
  before starting a job= it going to check whether there are any threads that finished the 
  job.. reuse them
  - if there are no waiting threads - it is going to create another one
  - good for the processor... effective solution!!!
  
  2.ExecutorService executorService = Executors.newFixedThreadPool(N);
  -maximaze the number of threads
  - if we want to start a job- if all the threads are busy we have to wait for one to 
    terminate
   3. ExecutorService executorService= Executor.newSingleThreadExecutor();
   it uses a single thread for the job
    execute()->runnable + callable
    submit()->runnable
 */

public class App {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			executorService.submit(new Worker());
		}
	}

}

class Worker implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
}
