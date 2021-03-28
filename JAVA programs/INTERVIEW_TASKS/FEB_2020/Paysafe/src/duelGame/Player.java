package duelGame;

public class Player {
	
	private String name;
	private Integer totalGamePoints;
	private Integer duelPoints;
	
	
	public Player(String name) {
		super();
		this.name = name;
		this.totalGamePoints = 0;
		this.duelPoints = 0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getTotalGamePoints() {
		return totalGamePoints;
	}

	public void setTotalGamePoints(Integer totalGamePoints) {
		this.totalGamePoints = totalGamePoints;
	}

	public Integer getDuelPoints() {
		return duelPoints;
	}
	public void setDuelPoints(Integer duelPoints) {
		this.duelPoints = duelPoints;
	}
}
