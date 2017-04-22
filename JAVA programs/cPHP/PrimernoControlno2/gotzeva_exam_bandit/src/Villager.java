
public class Villager {

	public Villager() {
		// TODO Auto-generated constructor stub
		numLegs = 2;
		numHands = 2;
		numEyes = 2;
		brokenNouse = false;
		name = "";
		horseName = "";
		whiskey = "";
	}
	
	public Villager(int numLegs, int numHands, int numEyes,
			boolean brokenNouse, String name, String horseName, String whiskey) {
		super();
		this.numLegs = numLegs;
		this.numHands = numHands;
		this.numEyes = numEyes;
		this.brokenNouse = brokenNouse;
		this.name = name;
		this.horseName = horseName;
		this.whiskey = whiskey;
	}

	protected int numLegs;
	protected int numHands;
	protected int numEyes;
	protected boolean brokenNouse;
	protected String name;
	protected String horseName;
	protected String whiskey;
	
	public String getName() {
		return name;
	}
	public String getWhiskey() {
		return whiskey;
	}

}
