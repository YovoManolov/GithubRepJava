
public class MyThread implements Runnable {
	private int threadIndex;
	private int threadVar ;
	
	
	public MyThread(int threadIndex, int threadVar) {
		super();
		this.threadIndex = threadIndex;
		this.threadVar = threadVar;
	}
	
	@Override
	public void run() {

			while(true) {
				try {

					 Main.semaphore.acquire();
					if((Main.globalVar / threadVar) != 0) {
						Main.globalVar += 1;
						System.out.println("The globalVar is:  " +
								Main.globalVar + " inside thread " + getThreadIndex());

						  Main.semaphore.release();	
							Thread.sleep(this.getThreadVar()*1000);
						
					}else if ((Main.globalVar / threadVar)  == 0) {
						Main.globalVar += 1;
						System.out.println("The globalVar is:  " +
								Main.globalVar + " inside thread " + getThreadIndex());

						 Main.semaphore.release(); 
							Thread.sleep(1000);
					
					}else if((Main.globalVar / (threadVar*threadVar))  == 0){
						Main.globalVar += (2*threadVar+1);
						System.out.println("The globalVar is:  " +
								Main.globalVar + " inside thread " + getThreadIndex());

						Main.semaphore.release(); 
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					 Main.semaphore.release();
				}
			}
		
	}

	public int getThreadIndex() {
		return threadIndex;
	}

	public void setThreadIndex(int threadIndex) {
		this.threadIndex = threadIndex;
	}

	public int getThreadVar() {
		return threadVar;
	}

	public void setThreadVar(int threadVar) {
		this.threadVar = threadVar;
	}

}
