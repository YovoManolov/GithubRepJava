package server;
//for(int i = 0; i < evalutation.size(); i++){
//	sumRating += evaluation.get(i);	
//}
//
//rating = sumRating/evaluation.size();

public class RateThread extends Thread{
	
	public RateThread() {
		
	}
	@Override
	public void run() {
		System.out.println("RATE THREAD");
	}

}
