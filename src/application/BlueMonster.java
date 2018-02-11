package application;

import javafx.scene.image.Image;

public class BlueMonster extends Monster{

	public BlueMonster(Image spriteImage, double posX, double posY, double velX, double velY) {
		super(spriteImage, posX, posY, velX, velY);
		
	}
	
	
	@Override
	public void update(double timer) {
		this.move();
	}
	


}
