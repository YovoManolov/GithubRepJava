package kgr.final_exam;

import java.awt.Font;
import java.io.IOException;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL; //Incase sound is provided
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 * 
 * This is a <em>very basic</em> skeleton to init a game and run it.
 * 
 * start() -> init() -> run() -> cleanup()
 * 
 * Gameloop - run() Logic - logic() - Here all calculations are made and then 
 * collection of the user input Render 
 * 
 * - render() - Here every graphic object is drawn to the screen
 *
 * 
 * Task: Draw tiles to the screen and draw an avatar, which can move in any
 * direction (right/left)
 * 
 * @author Desislav Andreev
 * @version 1.0 
 */
public class VirtualSpace {

	/** Game title */
	public static final String GAME_TITLE = "My Game";

	/** Screen size */
	public static int SCREEN_SIZE_WIDTH = 1280;
	public static int SCREEN_SIZE_HEIGHT = 718;
	public static int OFFSET = 50;
	public static int RATE = 20;

	/** Desired frame time */
	private static final int FRAMERATE = 60;

	/** Exit the game */
	private boolean finished;
	private boolean gameOver;

	private GameSprite tile;
	private StatsSprite lives;
	private Entity avatar;
	private TrueTypeFont font, endGameFont;
	private int coefficient = 1; //used for making the game harder after certain points
	private int difficulty = 1000; //on every 1000 points the game becomes harder
	
	public void start() {
		try {
			init();
			run();
		} catch (Exception e) {
			e.printStackTrace(System.err);
			Sys.alert(GAME_TITLE, "An error occured and the game will exit.");
		} finally {
			cleanup();
		}

		System.exit(0);
	}

	private void init() throws Exception {
		// Create a fullscreen window with 1:1 orthographic 2D projection, and with mouse, keyboard, and gamepad inputs.
		initGL(SCREEN_SIZE_WIDTH, SCREEN_SIZE_HEIGHT);

		try {
			gameOver = false; //Game Over indicator
			Texture txtAvatar = TextureLoader.getTexture("PNG",ResourceLoader.getResourceAsStream("res/avatar1.png"));

			tile = LevelHelper.getCurrLevel().getTile();
			avatar = new HeroEntity(this, new GameSprite(txtAvatar), 1024, 748);
			lives = new StatsSprite();
		} catch (IOException e) {
			e.printStackTrace();
			finished = true;
		}
	}

	private void initGL(int width, int height) {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(GAME_TITLE);
			Display.setFullscreen(false);
			Display.create();

			// Enable vsync if we can
			Display.setVSyncEnabled(true);

			// Start up the sound system
			AL.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		GL11.glEnable(GL11.GL_TEXTURE_2D);

		GL11.glClearColor(255.0f, 255.0f, 255.0f, 0.0f);

		// enable alpha blending
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glViewport(0, 0, width, height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
		font = new TrueTypeFont(awtFont, true);
		
		Font awtEndFont = new Font("Times New Roman", Font.BOLD, 60);
		endGameFont = new TrueTypeFont(awtEndFont, true);
	}

	/**
	 * Runs the game (the "main loop")
	 */
	private void run() {
		while (!finished && !gameOver) {
			// Always call Window.update(), all the time
			Display.update();

			if (Display.isCloseRequested()) {
				// Check for O/S close requests
				finished = true;
			} else if (Display.isActive()) {
				// The window is in the foreground, so we should play the game
				logic();
				render();
				Display.sync(FRAMERATE);
			} else {
				// The window is not in the foreground, so we can allow other
				// stuff to run and
				// infrequently update
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
				logic();
				if (Display.isVisible() || Display.isDirty()) {
					// Only bother rendering if the window is visible or dirty
					render();
				}
			}
		}
		if (gameOver) {
			while(!finished) {
				if (Display.isCloseRequested()) {
					// Check for O/S close requests
					finished = true;
				}
				renderEndStats();
				Display.update();
				Display.sync(FRAMERATE);
			}
		}
	}

	/**
	 * Do any game-specific cleanup
	 */
	private void cleanup() {
		// Stop the sound
		AL.destroy();

		// Close the window
		Display.destroy();
	}

	/**
	 * Do all calculations, handle input, etc.
	 */
	private static final int H_STEP = 10;
	double velocity = 0;
	boolean jumping = false;

	private void logic() {
		// Example input handler: we'll check for the ESC key and finish the game instantly when it's pressed
		
		LevelHelper.updateLevel();
		HeroEntity hero = (HeroEntity)avatar;

		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) || ((HeroEntity)avatar).getLives() <= 0) {
			gameOver = true;
			return;
		}

		int diffX_Avatar = 0;
		int diffY_Avatar = 0;

		//Handle keyboard input for controlling the avatar on Y axis
		if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			diffX_Avatar = H_STEP;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			diffX_Avatar = (-1) * H_STEP;
		}
		
		//Handle keyboard input for controlling the avatar on X axis
		if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			diffY_Avatar = H_STEP;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_UP)) {
				diffY_Avatar = (-1) * H_STEP;
		}

		boolean success = moveObject(avatar, diffX_Avatar, diffY_Avatar);

		List<ObjectEntity> portal = LevelHelper.getCurrLevel().getPortal();
		for (int i = portal.size() - 1; i >= 0; i--) {
			ObjectEntity oe = portal.get(i);
			if (avatar.collidesWith(oe)) {
				avatar.collidedWith(oe);
			}
		}
		List<ObjectEntity> stations = LevelHelper.getCurrLevel().getStations();
		for(int i = 0; i < stations.size(); i++) {
			if (avatar.collidesWith(stations.get(i))) {
				avatar.collidedWith(stations.get(i));
			}
		}
		
		if (false == success) {
			// do something if required
		}
	}

	// moves object in given direction(s)
	// if object meets screen borders before the whole distance is covered,
	// the object is either translated only by a partial distance, or none
	// (possible to add extra logic for that) and function returns false
	@SuppressWarnings("unused")
	private boolean moveObject(Entity obj, int diffX, int diffY) {

		if (obj == null) {
			return true;
		}

		Entity secondEnt = null;

		// would-be coordinates
		int futureX = obj.getX() + diffX;
		int futureY = obj.getY() + diffY;
		// flag if whole distance is covered successfully
		boolean res = true;
		// image dimensions
		int width = obj.getWidth();
		int height = obj.getHeight();
		// test future x-position, modify if required
		if (futureX < 0) {
			if (secondEnt == null || secondEnt.getX() == 0) {
					futureX = 0; // set to the left-most allowed position
					res = false;
			} else {
				futureX = 0; // set to the left-most allowed position
				res = false;
			}
		} else if (futureX + width > SCREEN_SIZE_WIDTH) {

			if (secondEnt == null
					|| secondEnt.getX() + secondEnt.getWidth() == SCREEN_SIZE_WIDTH) {

				futureX = SCREEN_SIZE_WIDTH - width; // set to the right-most allowed position
				res = false;
			} else {
				futureX = SCREEN_SIZE_WIDTH - width; // set to the right-most allowed position
				res = false;
			}
		}
		// test future y-position, modify if required
		if (futureY < 0) {
			futureY = 0;
			res = false;
		} else if (futureY + height > SCREEN_SIZE_HEIGHT) {
			futureY = SCREEN_SIZE_HEIGHT - height*coefficient;
			res = false;
		}

		// true: move object even if only a partial distance is possible
		// false: if full translation is impossible, do not move object at all
		boolean shouldMoveObject = true; // currently: always move object
		// shouldMoveObject = ... //implement some extra logic,
		// e.g declare a boolean field in class MyObject
		// so that we can decide what to do with each moving object individually
		if (res || shouldMoveObject) {
			obj.setX(futureX);
			obj.setY(futureY);
		}

		return res;
	}

	/**
	 * Render the current frame
	 */
	private void render() {

		rendTiles();
		rendPortals();
		rendStations();
		
		// Drawing the avatar
		avatar.draw();
		rendStats();
		rendHearts();
	}
	
	private void renderEndStats() {
		String points = ((HeroEntity)avatar).getTreasureCount() + "";
		rendTiles();
		//Get the center of the screen with some RATE, according to the size of the string
		endGameFont.drawString(SCREEN_SIZE_WIDTH / 2 - RATE * points.length(), SCREEN_SIZE_HEIGHT / 2 - RATE, points);
	}
	
	private void rendStats() {
		font.drawString(10, 10, ((HeroEntity)avatar).getTreasureCount() + "");
		if(((HeroEntity)avatar).getTreasureCount() > difficulty*coefficient)
		{
			coefficient +=1;
		}
	}
	
	private void rendStations() {
		for(ObjectEntity station : LevelHelper.getCurrLevel().getStations()) {
			station.draw();
		}
	}

	private void rendPortals() {
		List<ObjectEntity> portal = LevelHelper.getCurrLevel().getPortal();
		for (ObjectEntity obj : portal) {
			obj.draw();
		}
	}

	private void rendHearts()
	{
		for(int i = 0; i < ((HeroEntity)avatar).getLives(); i++)
		{
			//Draw hearts with an offset according to the right border; The rate is being used for drawing the hearts with a certain RATE from one another
			lives.draw(SCREEN_SIZE_WIDTH - OFFSET - i*RATE, 0);
		}
	}
	
	private void rendTiles() {

		GameSprite tile = LevelHelper.getCurrLevel().getTile();

		int imgH = tile.getHeight();
		int imgW = tile.getWidth();

		int rowTiles = SCREEN_SIZE_WIDTH / imgW;
		int colTiles = SCREEN_SIZE_HEIGHT / imgH;

		// if tiles are not enough to cover the whole area
		if (SCREEN_SIZE_HEIGHT % imgH != 0) {
			colTiles++;
		}
		if (SCREEN_SIZE_WIDTH % imgW != 0) {
			rowTiles++;
		}

		for (int i = 0; i < rowTiles; i++) {
			for (int j = 0; j < colTiles; j++) {
				int x = (int) (i * imgW);
				int y = (int) (j * imgH);
				tile.draw(x, y);
			}
		}
	}

	public void notifyTreasureCollected(HeroEntity heroEntity, Entity other) {
		if (false == heroEntity.collidesWith(other)) { //if no collision is registered
			return;
		}

		if (other instanceof ObjectEntity) {
			Level lvl = LevelHelper.getCurrLevel();
			
			ObjectEntity item = (ObjectEntity) other;
			
			if (lvl.isPortal(item)) {
				if (lvl.collectPortal(item)) {
					heroEntity.incrementTreasureCount();
				}
			} else {
				if (lvl.collectStation(item)) {
					heroEntity.decrementLives();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		VirtualSpace myGame = new VirtualSpace();
		myGame.start(); //Initiate game window
	}
}
