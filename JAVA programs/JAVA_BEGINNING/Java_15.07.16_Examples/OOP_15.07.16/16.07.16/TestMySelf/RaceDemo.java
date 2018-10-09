package TestMySelf;
/*
 400 m 
 10 threads (racers)
 5 groups
 first start , in the middle the second of the group take the race 
 all groups shoud start spontaniously
 */
public class RaceDemo {

	public static void main(String[] args) {
		Racer racer = new Racer();
		
		 // (Runnable Arg ,String 1);
		
		ThreadGroup tg =  new ThreadGroup("Albania");
		Thread firstThread = new Thread (tg, racer , "first"); // (ThreadGroup,Runnable Arg ,String 1);
		Thread secondThread = new Thread (tg, racer ,"second"); // (ThreadGroup,Runable Arg ,String 1);
		
		tg =  new ThreadGroup("Algeria");
		Thread thirdThread = new Thread (racer , "third");
		Thread fourthThread = new Thread (racer , "fourth");
		
		tg =  new ThreadGroup("Argentina");
		Thread fifthThread = new Thread (racer ,"fifth");
		Thread sixthThread = new Thread (racer ,"sixth");
		
		tg = new ThreadGroup("Armenia");
		Thread seventhThread = new Thread (racer ,"seventh");
		Thread eigthThread = new Thread (racer , "eigth");
		
		tg = new ThreadGroup("Brazil");
		Thread ninthThread = new Thread (racer , "ninth");
		Thread tenthThread = new Thread (racer , "tenth");
		

		firstThread.start();
		
		secondThread.start();
		thirdThread.start();
	    fourthThread.start(); 
		fifthThread.start(); 
		sixthThread.start(); 
		seventhThread.start();
		eigthThread.start(); 
		ninthThread.start();
		tenthThread.start();
	    
		
	}   
	   

}
