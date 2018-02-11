package application;

import javafx.scene.image.Image;

public class PinkMonster extends Monster {

	public PinkMonster(Image spriteImage, double posX, double posY, double velX, double velY) {
		super(spriteImage, posX, posY, velX, velY);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(double timer) {
		this.move();
	}

}
