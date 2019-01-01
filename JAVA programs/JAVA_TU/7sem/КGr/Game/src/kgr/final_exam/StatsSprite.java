package kgr.final_exam;

import java.io.IOException;

import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.opengl.Texture;

public class StatsSprite {
	private static Texture txtHeart;
	
	public void draw(int x, int y) {
		try
		{
			txtHeart = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/heart1.png"));
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		GameSprite sprite = new GameSprite(x, y, 30, 30, txtHeart);
		sprite.draw(x, y);
	}
}