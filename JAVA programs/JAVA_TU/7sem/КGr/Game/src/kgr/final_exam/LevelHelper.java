package kgr.final_exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class LevelHelper {

	private static final int LEVEL = 1;
	private static Level currLevel = null;
	private static final int PORTAL_COUNT = 10;
	private static final int STATIONS_COUNT = 3;
	private static Texture txtPortal;
	private static Texture txtStation;
	
	private static final Map<Integer, Level> levelMap = new HashMap<>();
	
	static {
		try {
			txtPortal = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/portal1.png"));
			txtStation = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/station1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			String path = "res/background1"+".png";
			try {
				Texture txtTile = TextureLoader.getTexture("PNG",
						ResourceLoader.getResourceAsStream(path));
				LevelTile tile = new LevelTile(txtTile);
				Level lvl = new Level(2, tile);
				while(lvl.getPortal().size() < PORTAL_COUNT){
					int x = (int) (Math.random() * (VirtualSpace.SCREEN_SIZE_WIDTH - txtPortal.getImageWidth()));
					int y = (int) (Math.random() * (VirtualSpace.SCREEN_SIZE_HEIGHT / 5));
					ObjectEntity portal = new ObjectEntity(new GameSprite(txtPortal), x, y);
					lvl.addPortal(portal);
				}
				
				while(lvl.getPortal().size() < STATIONS_COUNT){
					int x = (int) (Math.random() * (VirtualSpace.SCREEN_SIZE_WIDTH - txtStation.getImageWidth()));
					int y = (int) (Math.random() * (VirtualSpace.SCREEN_SIZE_HEIGHT / 5));
					ObjectEntity station = new ObjectEntity(new GameSprite(txtStation), x, y);
					lvl.addStation(station);
				}
				
				levelMap.put(LEVEL, lvl);
			} catch (IOException e) {
				e.printStackTrace();
		}
		
		setLevel(LEVEL);
	}
	
	public static void updateLevel() {
		List<ObjectEntity> portals = new ArrayList(currLevel.getPortal());
		List<ObjectEntity> stations = new ArrayList(currLevel.getStations());
		
		for (int c = 0; c < stations.size(); ++c) {
			stations.get(c).setY(stations.get(c).getY() + 7);
			if (stations.get(c).getY() - txtStation.getImageHeight() > VirtualSpace.SCREEN_SIZE_HEIGHT ) {
				currLevel.collectStation(stations.get(c));
			}
		}
		
		for (int c = 0; c < portals.size(); ++c) {
			portals.get(c).setY(portals.get(c).getY() + 10);
			if (portals.get(c).getY() - txtPortal.getImageHeight() > VirtualSpace.SCREEN_SIZE_HEIGHT ) {
				currLevel.collectPortal(portals.get(c));
			}
		}
		
		while(currLevel.getStations().size() < STATIONS_COUNT) {
			int x = (int) (Math.random() * (VirtualSpace.SCREEN_SIZE_WIDTH - txtStation.getImageWidth()));
			ObjectEntity station = new ObjectEntity(new GameSprite(txtStation), x, 0);
			currLevel.addStation(station);
		}
		
		while(currLevel.getPortal().size() < PORTAL_COUNT) {
			int x = (int) (Math.random() * (VirtualSpace.SCREEN_SIZE_WIDTH - txtPortal.getImageWidth()));
			ObjectEntity portal = new ObjectEntity(new GameSprite(txtPortal), x, 0);
			currLevel.addPortal(portal);
		}
		
	}
	
	public static Level setLevel(int lvl){
		Level level = levelMap.get(lvl);
		
		currLevel = level;
		return currLevel;
	}
	
	public static Level getCurrLevel(){
		return currLevel;
	}
}
