package kgr.final_exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level {

	private int lvl = 0;
	private LevelTile tile = null;
	
	private List<ObjectEntity> portal = new ArrayList();
	private List<ObjectEntity> stations = new ArrayList();
	
	public Level(int lvl, LevelTile tile){
		this.lvl = lvl;
		this.tile = tile;
	}
	
	public int getLvl(){
		return lvl;
	}
	
	public LevelTile getTile(){
		return tile;
	}
	
	public List<ObjectEntity> getPortal(){
		return portal;
	}
	
	public List<ObjectEntity> getStations() {
		return stations;
	}
	
	public boolean isPortal(ObjectEntity obj) {
		return portal.contains(obj);
	}
	
	public boolean isStation(ObjectEntity obj) {
		return !isPortal(obj);
	}
	
	public boolean addPortal(ObjectEntity obj){		
		return portal.add(obj);
	}
	
	public boolean addStation(ObjectEntity obj) {
		return stations.add(obj);
	}
	
	public boolean collectPortal(ObjectEntity obj){
		return portal.remove(obj);
	}

	public boolean collectStation(ObjectEntity obj) {
		return stations.remove(obj);
	}
	
}
