
public class RegisterTown extends WesternTown {

	public RegisterTown() {
		// TODO Auto-generated constructor stub
	}

	public RegisterTown(String address, int year, 
			int numBars, int numSheriffs,
			Villager[] villagers, Sheriff sheriffName) {
		super(address, Math.max(1890, year), numBars, numSheriffs);
		// TODO Auto-generated constructor stub
		this.villagers = villagers;
		this.sheriffName = sheriffName;
	}

	protected Villager[] villagers;
	protected Sheriff sheriffName;
}
