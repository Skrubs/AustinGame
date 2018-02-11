package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Player extends Sprite{
	
	private boolean shoot;

	public Player(Image spriteImage, double posX, double posY, double velX, double velY) {
		super(spriteImage, posX, posY, velX, velY, Id.player);
		shoot = false;
	}
	
	

	@Override
	public Rectangle2D getBoundary() {
		return new Rectangle2D(this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight());
	}

	@Override
	public void move() {
		this.move(this.getVelX(), this.getVelY());
		
	}

	@Override
	public void update(double timer) {
		
		move();
		
	}

	@Override
	public void render(GraphicsContext gc, double timer) {
		gc.drawImage(this.getSpriteImage(), this.getPosX(), this.getPosY());
		
	}
	
	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
	
	public boolean getShoot() {
		return shoot;
	}

}
