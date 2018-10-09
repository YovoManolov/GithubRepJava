
public class Pipe implements Runnable {
	
	private int pipeIndex;
	private int updateVolume;
	private int sleepInMilliseconds;
	

	public Pipe(int pipeIndex,int updateVolume, int sleepInMilliseconds) {
		super();
		this.pipeIndex = pipeIndex;
		this.updateVolume = updateVolume;
		this.sleepInMilliseconds = sleepInMilliseconds;
	}

	@Override
	public void run() {
		try
		{
			while(true)
			{
				Test.semaphore.acquire();
				System.out.println("Pipe " + pipeIndex + " got permission");
				
				try
				{
					Test.waterInPool += updateVolume;
					if((Test.waterInPool> Test.maxPoolCapacity))
					{
						Test.waterInPool = 3000;
						System.out.println(Test.waterInPool + " liters in the pool");
						System.out.println("THE POOL IS FULL!");
						Test.semaphore.release();
						Thread.sleep(5000);
					}else if(Test.waterInPool < Test.minPoolCapacity) {
						Test.waterInPool = 0;
						System.out.println(Test.waterInPool + " liters in the pool");
						System.out.println("THE POOL IS EMPTY!");
						Test.semaphore.release();
						Thread.sleep(10000);
					}
					else
					{
						System.out.println(Test.waterInPool + " liters in the pool");
						Thread.sleep(sleepInMilliseconds);
					}
				}finally{
					Test.semaphore.release();
				}
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}

	}

}
