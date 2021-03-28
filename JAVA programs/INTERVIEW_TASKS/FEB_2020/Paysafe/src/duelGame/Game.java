package duelGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Game {

	private Player winner;
	private Player playerOne;
	private Player playerTwo;
	private List<ScoreCard> synchronizedScoreCard;

	static final int MAX_T = 5;

	public Game(Player playerOne, Player playerTwo) {
		super();
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	
	private Callable<Void> toCallable(final Runnable runnable) {
	    return new Callable<Void>() {
	        @Override
	        public Void call() {
	            runnable.run();
	            return null;
	        }
	    };
	}

	public void playTheGame() {

		synchronizedScoreCard = Collections.synchronizedList(new LinkedList<ScoreCard>());
		
		List<Callable<Void>> callables = new ArrayList<>();
		
		List<Runnable> runnables = new LinkedList<Runnable>();
		runnables.add(new Duel(playerOne, playerTwo, synchronizedScoreCard));
		runnables.add(new Duel(playerOne, playerTwo, synchronizedScoreCard));
		runnables.add(new Duel(playerOne, playerTwo, synchronizedScoreCard));
		runnables.add(new Duel(playerOne, playerTwo, synchronizedScoreCard));
		runnables.add(new Duel(playerOne, playerTwo, synchronizedScoreCard));
		
		for (Runnable r : runnables) {
		    callables.add(toCallable(r));
		}

		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
		try {
			pool.invokeAll(callables);
			chooseTheWinner(playerOne, playerTwo, synchronizedScoreCard);
			printGameResult(synchronizedScoreCard);
			if(pool.isTerminated()) {
				pool.shutdown();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void printGameResult(List<ScoreCard> synchronizedScoreCard) {

		System.out.println("\n result winner: \n");

		List<ScoreCard> filteredResult = synchronizedScoreCard.stream()
				.filter(sc -> sc.getDuelWinner().equals(winner.getName())).collect(Collectors.toList());

		if (playerOne.getName().equals(winner.getName())) {

			System.out.println("Winner : " + winner.getName() + " total points " + playerOne.getTotalGamePoints());

			for (ScoreCard sc : filteredResult) {
				System.out.println("(" + sc.getScoreFirstPlayer() + ") " + sc.getNameFirstPlayer() + " <=> " + "("
						+ sc.getScoreSecondPlayer() + ") " + sc.getNameSecondPlayer() + "( "
						+ sc.getScoreDiffFirstPlayer() + ")");
			}

		} else {
			System.out.println("Winner : " + winner.getName() + " total points " + playerTwo.getTotalGamePoints());

			for (ScoreCard sc : filteredResult) {
				System.out.println("(" + sc.getScoreFirstPlayer() + ") " + sc.getNameFirstPlayer() + " <=> " + "("
						+ sc.getScoreSecondPlayer() + ") " + sc.getNameSecondPlayer() + "( "
						+ sc.getScoreDiffSecondPlayer() + ")");
			}
		}

		System.out.println("\n result loser: \n");

		if (playerOne.getName().equals(winner.getName())) {
			System.out.println("Loser : " + playerTwo.getName() + "total points " + playerTwo.getTotalGamePoints());

			for (ScoreCard sc : filteredResult) {
				System.out.println("(" + sc.getScoreFirstPlayer() + ") " + sc.getNameFirstPlayer() + " <=> " + "("
						+ sc.getScoreSecondPlayer() + ") " + sc.getNameSecondPlayer() + "( "
						+ sc.getScoreDiffSecondPlayer() + ")");
			}
		} else {
			System.out.println("Loser : " + playerOne.getName() + "total points " + playerOne.getTotalGamePoints());

			for (ScoreCard sc : filteredResult) {
				System.out.println("(" + sc.getScoreFirstPlayer() + ") " + sc.getNameFirstPlayer() + " <=> " + "("
						+ sc.getScoreSecondPlayer() + ") " + sc.getNameSecondPlayer() + "( "
						+ sc.getScoreDiffFirstPlayer() + ")");
			}

		}

	}

	private void chooseTheWinner(Player playerOne, Player playerTwo, List<ScoreCard> synchronizedScoreCard) {
		for (ScoreCard sc : synchronizedScoreCard) {

			if (sc.getScoreFirstPlayer() != sc.getScoreSecondPlayer()) {
				int diff = 0;
				if (sc.getScoreFirstPlayer() > sc.getScoreSecondPlayer()) {

					sc.setDuelWinner(playerOne.getName());
					diff = sc.getScoreFirstPlayer() - sc.getScoreSecondPlayer();
					sc.setScoreDiffFirstPlayer(diff);
					playerOne.setTotalGamePoints(playerOne.getTotalGamePoints() + diff);
					sc.setScoreDiffSecondPlayer(0 - diff);
					playerTwo.setTotalGamePoints(playerTwo.getTotalGamePoints() - diff);
				} else {
					sc.setDuelWinner(playerTwo.getName());
					diff = sc.getScoreSecondPlayer() - sc.getScoreFirstPlayer();
					sc.setScoreDiffSecondPlayer(diff);
					playerTwo.setTotalGamePoints(playerTwo.getTotalGamePoints() + diff);
					sc.setScoreDiffFirstPlayer(0 - diff);
					playerOne.setTotalGamePoints(playerOne.getTotalGamePoints() - diff);
				}
			}
		}

		if (playerOne.getTotalGamePoints() != playerTwo.getTotalGamePoints()) {
			if (playerOne.getTotalGamePoints() > playerTwo.getTotalGamePoints()) {
				winner = playerOne;
			} else {
				winner = playerTwo;
			}
		} else {
			System.out.println("Draw");
		}
	}

}
