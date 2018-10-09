package TestMySelf;
import java.lang.*;


	public class Racer implements Runnable {
		  
		Thread t1 ;
		Racer (ThreadGroup tg) {
			t1 = tg.
		}
		   public static String winner;
		   public void race( ){
			   
			  for(int distance = 1 ; distance <= 200 ; distance++ ){
				   
				   
				   boolean isRaceWon = this.isRaceWon(distance);
				   if(isRaceWon){
				      break;
			       }    
		      } 
		}
    }

	 private boolean isRaceWon(totalDistanceCovered) {
	 boolean isRaceWon = false;
				 if((totalDistanceCovered == 400) && (Racer.winner == null)){
					String winnerName = Thread.currentThread().getName();
					Racer.winner = winnerName;
				    System.out.println("Winner is " + winnerName);
					isRaceWon = true;	 
				 }
				 else if (Racer.winner == null){
					 isRaceWon = false;
				 }
				 else if (Racer.winner != null){
					 isRaceWon = true;
				 }
		   return isRaceWon;
	}