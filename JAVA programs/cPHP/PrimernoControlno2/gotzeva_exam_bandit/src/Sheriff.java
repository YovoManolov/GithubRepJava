
public class Sheriff extends Villain {

	public Sheriff() {
		// TODO Auto-generated constructor stub
	}

	public Sheriff(int numLegs, int numHands, int numEyes, String name,
			String horseName, String whiskey, String shortName, int numShoots,
			int price) {
		super(numLegs, numHands, numEyes, name, horseName, whiskey, shortName,
				numShoots, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int Shoot() {
		// TODO Auto-generated method stub
		return Math.min(super.Shoot()+20, 100);
	}

}
