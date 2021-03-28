package duelGame;

import java.util.List;
import java.util.Random;

public class Duel implements Runnable {

	Player playerOne;
	Player playerTwo;
	List<ScoreCard> listScoreCard;
	Random random = new Random();

	public Duel(Player playerOne, Player playerTwo,List<ScoreCard> listScoreCard) {
		super();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.listScoreCard = listScoreCard;
	}

	@Override
	public void run() {
		playerOne.setDuelPoints(random.nextInt(Integer.SIZE - 1) %15);
		playerTwo.setDuelPoints(random.nextInt(Integer.SIZE - 1) %15);
		
		setDuelResult(playerOne,playerTwo, listScoreCard);
	}
	
	
	private synchronized void setDuelResult(Player playerOne,Player playerTwo,List<ScoreCard> listScoreCard) {
		
		ScoreCard scoreCard = new ScoreCard(playerOne.getName(),playerTwo.getName()
					, playerOne.getDuelPoints(), playerTwo.getDuelPoints());
		
		listScoreCard.add(scoreCard);
	}

}
