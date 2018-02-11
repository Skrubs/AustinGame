package application;

import java.util.ArrayList;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Bullet extends Sprite {

	public Bullet(Image spriteImage, double posX, double posY, double velX, double velY) {
		super(spriteImage, posX, posY, velX, velY, Id.bullet);
		
	}

	@Override
	public void update(double timer) {
		
	}

	@Override
	public void render(GraphicsContext gc, double timer) {
		
	}

	@Override
	public Rectangle2D getBoundary() {
		return new Rectangle2D(this.getPosX(), this.posY, this.getWidth(), this.getHeight());
	}

	
	public void move(Player player) {
		this.move(player.getVelX()*4, player.getVelY()*4);
		
	}

	@Override
	public void move() {
		
		if(this.getVelX() == 0 && this.getVelY() == 0)this.setVelX(4);
		
		this.posX+= this.getVelX();
		this.posY+= this.getVelY();
		
	}


}
