package server;
import java.util.Scanner;

public class ReservationThread extends Thread{
	@Override
	public void run() {
		synchronized(this){
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your destination:");
			String dest = scan.nextLine();
			System.out.println("Send offer ID:");
			int offerID = scan.nextInt();
			
		}
	}
}
