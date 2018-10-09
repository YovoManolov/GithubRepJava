package server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
 
 
	public static void main(String[] args) throws IOException{
	Offert of = new Offert(1111, "Sofia", "Aris", 10.5, 6);
	User us = new User("sasho", "pass");
		
	ArrayList<Offert> offerts = new ArrayList<Offert>();
	ArrayList<User> users = new ArrayList<User>();
	offerts.add(of);
	users.add(us);
	
	Scanner scan = new Scanner(System.in);
	int option;
	
		System.out.println("Choose: 1. Reserve a hotel, \n       2.Rate an offer;");
		option = scan.nextInt();
		if(option == 1){
			new ReservationThread().start();
		}
		else if(option == 2){
			new RateThread().start();
		}
	}
	
}



