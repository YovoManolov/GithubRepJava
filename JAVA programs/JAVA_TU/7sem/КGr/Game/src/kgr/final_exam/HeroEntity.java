package kgr.final_exam;

public class HeroEntity extends Entity {
	
	private Object game;	
	private long treasureCount = 0;
	private int lives = 3; //define maximum lives
	
	public HeroEntity(Object game, GameSprite sprite, int x, int y) {
		super(sprite, x, y);
		this.game = game;
	}
	
	@Override
	public void collidedWith(Entity other) {
		VirtualSpace myGame = (VirtualSpace) game;
		myGame.notifyTreasureCollected(this, other);
	}
	
	public void incrementTreasureCount(){
		treasureCount+=30;
	}
	
	public long getTreasureCount(){
		return treasureCount;
	}

	public int getLives() {
		return lives;
	}

	public void decrementLives() {
		lives--;
	}
}
