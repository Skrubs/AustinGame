package application;

import javafx.scene.image.Image;

public class OrangeMonster extends Monster {

	public OrangeMonster(Image spriteImage, double posX, double posY, double velX, double velY) {
		super(spriteImage, posX, posY, velX, velY);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(double timer) {
		this.move();
	}

}
