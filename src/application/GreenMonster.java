package application;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GreenMonster extends Monster{

	public GreenMonster(Image spriteImage, double posX, double posY, double velX, double velY) {
		super(spriteImage, posX, posY, velX, velY);
		
	}
	
	@Override
	public void update(double timer) {
		this.move();
	}
	
	@Override
	public void render(GraphicsContext gc, double timer) {
		
	}

}
