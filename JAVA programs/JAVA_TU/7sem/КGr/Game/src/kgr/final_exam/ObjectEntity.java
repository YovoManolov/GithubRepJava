package kgr.final_exam;

public class ObjectEntity extends Entity{

	public ObjectEntity(GameSprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	@Override
	public void collidedWith(Entity other) {
		System.out.println("Collision detected ObjectEntity");
	}

}
