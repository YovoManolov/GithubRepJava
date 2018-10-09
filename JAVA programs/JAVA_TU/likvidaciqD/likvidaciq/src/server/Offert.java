package server;

import java.util.ArrayList;

public class Offert {

	int offertID;
	String destination; //city
	String nameOfHotel;
	double price;
	double rating; // 0 to 6
	ArrayList<Integer> evaluation;
		
	
	public Offert(int offertID, String destination, String nameOfHotel, 
				  double price, double rating) {
		this.offertID = offertID;
		this.destination = destination;
		this.nameOfHotel = nameOfHotel;
		this.price = price;
		this.rating = rating;
	}
}
