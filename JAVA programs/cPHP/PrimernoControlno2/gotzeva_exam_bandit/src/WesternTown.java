
public class WesternTown {

	public WesternTown() {
		// TODO Auto-generated constructor stub
		address = "West America";
		year = 1850;
		numBars = 2;
		numSheriffs = 1;
	}
	public WesternTown(String address, int year, int numBars, int numSheriffs) {
		super();
		this.address = address;
		this.year = year;
		this.numBars = numBars;
		this.numSheriffs = numSheriffs;
	}
	private String address;
	private int year;
	private int numBars;
	private int numSheriffs;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getNumBars() {
		return numBars;
	}
	public void setNumBars(int numBars) {
		this.numBars = numBars;
	}
	public int getNumSheriffs() {
		return numSheriffs;
	}
	public void setNumSheriffs(int numSheriffs) {
		this.numSheriffs = numSheriffs;
	}
}
