package RACE;

public class Racer implements Runnable {
   Thread runner1 ,runner2;
   
   Racer(Thread a , Thread b){
	   runner1 = a;
	   runner2 = b;
   }
   public long race(){
	long startTime = System.currentTimeMillis();
	   
	  for(int distance = 1 ; distance <= 200 ; distance ++ ){
		 if(distance == 1) runner1.start(); 
	  }
	  
	  for(int distance = 1 ; distance <= 200 ; distance ++){
		  final boolean a =  runner1.isAlive();
			  try{
				  if(!a){
					  runner2.start();
				  }else wait();
			  }catch(InterruptedException e){
				  
			  }
		 if(distance == 200){
			 System.out.println("Group has finished");
		 }
	  }	
	  
	  long endTime   = System.currentTimeMillis();
	  long totalTime = endTime - startTime;
		  
	return totalTime;
}


	public void run() {
		this.race();
		
	}
	
}