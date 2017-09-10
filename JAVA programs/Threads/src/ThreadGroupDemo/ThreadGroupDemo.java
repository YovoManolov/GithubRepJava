package ThreadGroupDemo;

class ThreadGroupDemo {

	public static void main(String[] args) {
		ThreadGroup A = new ThreadGroup("Group A"); 
		ThreadGroup B = new ThreadGroup("Group B");
		
		///NewThread(String threadName , ThreadGroup tgob) ;
		
	    NewThread ob1 = new NewThread("One" ,A);
		NewThread ob2 = new NewThread("Two" ,A);
		NewThread ob3 = new NewThread("Three",B);
		NewThread ob4 = new NewThread("Four" ,B);
		
		System.out.println("Here is the output from list() : ");
        A.list();
        B.list();
        System.out.println();
        
        System.out.println("Suspending Group A");
        Thread tga[] = new Thread [A.activeCount()];
        System.out.println("Active threads in the current"
        	               + " THreadGroup " + A.activeCount()); 
        A.enumerate(tga);  //get threads in group
        
        for( int i= 0 ;i <tga.length;i++){
        	((NewThread)tga[i]).mysuspend();
        	/* 
        	 * synchronized void mysuspend(){
		        suspendFlag = true;
	            }
	         */
        }
        try{
        	Thread.sleep(4000);
        	System.out.println("Thread is Sleeping for 4 seconds");
        	
        }catch(InterruptedException e){
	      System.out.println("Main thread interrupted .");
        }
        
        System.out.println("Resuming Group A");
        for(int i = 0; i<tga.length ; i ++){
        	((NewThread)tga[i]).myresume();
        	/* 
        	 * synchronized void myresume(){
			       suspendFlag = false;
			       notify();
	            }
	         */
        }
        
        try{
        	System.out.println("Waiting  for threads  to finish .");
        	//waits until the thread terminates  -- join();
        	ob1.join();
        	ob2.join();
        	ob3.join();
        	ob4.join();
        	
        }catch(Exception e){
        	System.out.println("Exception in my thread");
        }
        System.out.println("Main thread exiting");
	}
	

}
