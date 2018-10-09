package RACE;

public class RaceDemo {

	public static void main(String[] args) {
	
	

		Thread firstThread = new Thread ( "first"); // (ThreadGroup,Runnable Arg ,String 1);
		Thread secondThread = new Thread ("second");
		Thread thirdThread = new Thread ("third");
		Thread fourthThread = new Thread ("fourth");
		Thread fifthThread = new Thread ("fifth");
		Thread sixthThread = new Thread ("sixth");
		Thread seventhThread = new Thread ("seventh");
		Thread eigthThread = new Thread ("eigth");
		Thread ninthThread = new Thread ("ninth");
		Thread tenthThread = new Thread ("tenth");
		// if we wont the race to start we must tell the thrads to start 
		
		Racer racer = new Racer(firstThread , secondThread);
		
		Racer racer1 = new Racer(thirdThread , fourthThread);
		Racer racer2 = new Racer(fifthThread , sixthThread);
		Racer racer3 = new Racer(seventhThread ,eigthThread);
		Racer racer4 = new Racer(ninthThread , tenthThread);
		
		long[] Results = new long [5];
		
		Results[0] = racer.race();
		Results[1] = racer1.race();
		Results[2] = racer2.race();
		Results[3] = racer3.race();
		Results[4] = racer4.race();
        
		long bestTime;
		bestTime = findingMinTime(Results);
		
		System.out.println("The best time is : " + bestTime /1000);

	}
}
	

static long findingMinTime(long[] Results){
	 
	 long min = 99999999;
	 
	 for(int i = 0 ; i< Results.length ; i++){
		 if(min > Results[i]){
			 min = Results[i];
		 }
	 }
	 return min;
}
