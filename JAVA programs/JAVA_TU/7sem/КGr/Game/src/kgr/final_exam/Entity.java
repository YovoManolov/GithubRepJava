package kgr.final_exam;

import java.awt.Rectangle;

public abstract class Entity {
	private int x;
	private int y;
	private GameSprite sprite;
	private boolean visible;
	
	private Rectangle avatar = new Rectangle();
	private Rectangle collisionObject = new Rectangle();
	
	public Entity(GameSprite sprite, int x, int y) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		this.visible = true;
	}

	public void draw() {
		sprite.draw(x, y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return sprite.getWidth();
	}

	public int getHeight() {
		return sprite.getHeight();
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	//Implement object collision
	public boolean collidesWith(Entity other) {
		avatar.setBounds((int) x, (int) y, sprite.getWidth(), sprite.getHeight());
		collisionObject.setBounds((int) other.x, (int) other.y, other.sprite.getWidth(),other.sprite.getHeight());

		return avatar.intersects(collisionObject);
	}

	public abstract void collidedWith(Entity other);
}
