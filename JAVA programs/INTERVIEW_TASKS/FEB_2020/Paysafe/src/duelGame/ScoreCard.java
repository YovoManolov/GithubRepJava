package duelGame;

public class ScoreCard {

	private String nameFirstPlayer;
	private String nameSecondPlayer;
	private Integer scoreFirstPlayer;
	private Integer scoreSecondPlayer;
	private Integer scoreDiffFirstPlayer;
	private Integer scoreDiffSecondPlayer;
	private String duelWinner;
	
	public ScoreCard( String nameFirstPlayer,
			String nameSecondPlayer, Integer scoreFirstPlayer,
			Integer scoreSecondPlayer) {
		super();
		this.nameFirstPlayer = nameFirstPlayer;
		this.nameSecondPlayer = nameSecondPlayer;
		this.scoreFirstPlayer = scoreFirstPlayer;
		this.scoreSecondPlayer = scoreSecondPlayer;
	}

	public String getNameFirstPlayer() {
		return nameFirstPlayer;
	}

	public void setNameFirstPlayer(String nameFirstPlayer) {
		this.nameFirstPlayer = nameFirstPlayer;
	}

	public String getNameSecondPlayer() {
		return nameSecondPlayer;
	}

	public void setNameSecondPlayer(String nameSecondPlayer) {
		this.nameSecondPlayer = nameSecondPlayer;
	}

	public Integer getScoreFirstPlayer() {
		return scoreFirstPlayer;
	}

	public void setScoreFirstPlayer(Integer scoreFirstPlayer) {
		this.scoreFirstPlayer = scoreFirstPlayer;
	}

	public Integer getScoreSecondPlayer() {
		return scoreSecondPlayer;
	}

	public void setScoreSecondPlayer(Integer scoreSecondPlayer) {
		this.scoreSecondPlayer = scoreSecondPlayer;
	}

	public Integer getScoreDiffFirstPlayer() {
		return scoreDiffFirstPlayer;
	}

	public void setScoreDiffFirstPlayer(Integer scoreDiffFirstPlayer) {
		this.scoreDiffFirstPlayer = scoreDiffFirstPlayer;
	}

	public Integer getScoreDiffSecondPlayer() {
		return scoreDiffSecondPlayer;
	}

	public void setScoreDiffSecondPlayer(Integer scoreDiffSecondPlayer) {
		this.scoreDiffSecondPlayer = scoreDiffSecondPlayer;
	}

	public String getDuelWinner() {
		return duelWinner;
	}

	public void setDuelWinner(String duelWinner) {
		this.duelWinner = duelWinner;
	}
	
	
}
