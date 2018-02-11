package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Monster extends Sprite {

	public Monster(Image spriteImage, double posX, double posY, double velX, double velY) {
		super(spriteImage, posX, posY, velX, velY, Id.monster);
	
	}

	@Override
	public void update(double timer) {
	
		
	}

	@Override
	public void render(GraphicsContext gc, double timer) {
			
	}

	@Override
	public Rectangle2D getBoundary() {
		return new Rectangle2D(this.getPosX(), this.getPosY(), this.getWidth(), this.getHeight());
	}

	@Override
	public void move() {
		if(this.getPosX() >= Main.WINDOW_WIDTH || this.getPosX() < 0) {
			double opposite = this.getVelX()*(-1);
			this.setVelX(opposite);
		}
		
		if(this.getPosY() >= Main.WINDOW_HEIGHT || this.getPosY() < 0) {
			double oppositeY = this.getVelY() *(-1);
			this.setVelY(oppositeY);
		}
		this.posX += this.getVelX();
		
		this.posY += this.getVelY();
		
	}

}
