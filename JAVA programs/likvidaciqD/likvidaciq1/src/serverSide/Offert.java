package serverSide;

import java.util.ArrayList;

public class Offert {

	private int offertID;
	private String destination; //city
	private String nameOfHotel;
	private double price;
	private double rating; // 0 to 6
	private ArrayList<Integer> evaluation;
	
	
	public Offert(int offertID, String destination, String nameOfHotel, double price, double rating,
			ArrayList<Integer> evaluation) {
		super();
		this.offertID = offertID;
		this.destination = destination;
		this.nameOfHotel = nameOfHotel;
		this.price = price;
		this.rating = rating;
		this.evaluation = evaluation;
	}


	public int getOffertID() {
		return offertID;
	}


	public void setOffertID(int offertID) {
		this.offertID = offertID;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getNameOfHotel() {
		return nameOfHotel;
	}


	public void setNameOfHotel(String nameOfHotel) {
		this.nameOfHotel = nameOfHotel;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public ArrayList<Integer> getEvaluation() {
		return evaluation;
	}


	public void setEvaluation(ArrayList<Integer> evaluation) {
		this.evaluation = evaluation;
	}



}
