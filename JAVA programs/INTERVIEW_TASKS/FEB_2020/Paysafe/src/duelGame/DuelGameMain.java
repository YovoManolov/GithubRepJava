package duelGame;

public class DuelGameMain {

	public static void main(String[] args) {
		
		Player playerOne = new Player("doctor");
		Player playerTwo = new Player("panda");
		
		Game game1 = new Game(playerOne,playerTwo);
		game1.playTheGame();

	}

}
