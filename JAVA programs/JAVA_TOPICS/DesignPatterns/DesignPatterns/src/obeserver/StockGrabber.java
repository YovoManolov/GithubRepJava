package obeserver;

import java.util.ArrayList;

public class StockGrabber implements Subject {

	private ArrayList<Observer> observers;
	
	private double ibmPrice;
	private double aplPrice;
	private double googPrice;
	
	public StockGrabber() {
		observers = new ArrayList<Observer>();
	}
	

	@Override
	public void notifyObserver() {
		for(Observer observer: observers) {
			observer.update(ibmPrice, aplPrice, googPrice);
		}
	}

	@Override
	public void register(Observer newObserver){
		observers.add(newObserver);
	}

	@Override
	public void unregister(Observer deleteObserver) {
		
		int observerIndex = observers.indexOf(deleteObserver);
		
		observers.remove(observerIndex);
		System.out.println("Deleted observer:" + observerIndex+1 );
	}
	
	


	public void setIbmPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
		
	}


	public void setAplPrice(double aplPrice) {
		this.aplPrice = aplPrice;
		notifyObserver();
	}


	public void setGoogPrice(double googPrice) {
		this.googPrice = googPrice;
		notifyObserver();
	}
	
	
}
