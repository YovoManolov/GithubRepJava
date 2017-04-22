package YealdMethod;
import java.lang.Thread.State;
public class YealdDemo {

	public static void main(String[] args) {
		YealdRunnable yr = new YealdRunnable();
		
		ThreadGroup allThreads = new ThreadGroup("All Threads");
		Thread t1 = new Thread(allThreads,yr,"t1");  // Thread(ThreadGroup group, Runnable target, String name)
		Thread t2 = new Thread(allThreads,yr,"t2"); 
		Thread t3 = new Thread(allThreads,yr,"t3"); 
		Thread t4 = new Thread(allThreads,yr,"t4"); 
		Thread t5 = new Thread(allThreads,yr,"t5"); 
		Thread t6 = new Thread(allThreads,yr,"t6"); 
		Thread t7 = new Thread(allThreads,yr,"t7"); 
		Thread t8 = new Thread(allThreads,yr,"t8"); 
		Thread t9 = new Thread(allThreads,yr,"t9"); 
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		
		t4.setPriority(Thread.NORM_PRIORITY);
		t5.setPriority(Thread.NORM_PRIORITY);
		t6.setPriority(Thread.NORM_PRIORITY);
		
		t7.setPriority(Thread.MIN_PRIORITY);
		t8.setPriority(Thread.MIN_PRIORITY);
		t9.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		
		
//import java.lang.Thread.State;
// getting the status of each tread using the Main Thread
		while(true){
			State t1State = t1.getState();
			State t2State = t2.getState();
			State t3State = t3.getState();
			State t4State = t4.getState();
			State t5State = t5.getState();
			State t6State = t6.getState();
			State t7State = t7.getState();
			State t8State = t8.getState();
			State t9State = t9.getState();
			
			System.out.println(System.out.nanoTime()+ "t1 Status" + t1State);
			System.out.println(System.out.nanoTime()+ "t2 Status" + t2State);
			System.out.println(System.out.nanoTime()+ "t3 Status" + t3State);			
			System.out.println(System.out.nanoTime()+ "t4 Status" + t4State);			
			System.out.println(System.out.nanoTime()+ "t5 Status" + t5State);
			System.out.println((System.out).nanoTime()+ "t6 Status" + t6State);		
			System.out.println(System.out.nanoTime()+ "t7 Status" + t7State);
			System.out.println(System.out.nanoTime()+ "t8 Status" + t8State);
			System.out.println(System.out.nanoTime()+ "t9 Status" + t9State);
			
			int activeThreads = allThreads.activeCount();
			if(activeThreads == 0){
				break;
			} 		
			
		}
	}

}
