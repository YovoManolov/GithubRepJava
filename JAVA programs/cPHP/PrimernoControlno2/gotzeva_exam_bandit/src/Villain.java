import java.util.Random;


public class Villain extends Villager {

	public Villain() {
		// TODO Auto-generated constructor stub
		shortName = "";
		numShoots = 0;
		price = 0;
	}

	public Villain(int numLegs, int numHands, int numEyes, 
			String name, String horseName, String whiskey,
			String shortName, int numShoots, int price) {
		super(numLegs, numHands, numEyes, true, name, horseName, whiskey);
		// TODO Auto-generated constructor stub
		this.shortName = shortName;
		this.numShoots = numShoots;
		this.price = price;
	}

	protected String shortName;
	protected int numShoots;
	protected int price;

	public static void Skrmish(Villain a, Villain b){
		int resA;
		int resB;
		int res = 0;
		Villain c = null;
		do {
			resA = a.Shoot();
			resB = b.Shoot();
			System.out.println(resA+":"+resB);
			if (resA > resB){
				res = resA;
				c = a;
			}
			else if (resB > resA){
				res = resB;
				c = b;
			}
			if (res > 70){
				System.out.println("Villain "+c.name+" wins.");
				return;
			}
		} while (a.numShoots != 0 && b.numShoots != 0);
		System.out.println("No Winners");
	}
	
	public int Shoot(){	
		if (numShoots == 0)
			return 0;
		 
		Random r = new Random();
		numShoots--;
		return r.nextInt(101);
	}
}
