package application;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public abstract class Sprite {
	
	
	protected double posX;
	protected double posY;
	private double velX;
	private double velY;
	private double width;
	private double height;
	private Image spriteImage;
	private Id id;
	private boolean isAlive;
	
	public Sprite(Image spriteImage, double posX, double posY, double velX, double velY, Id id) {
		
		this.spriteImage = spriteImage;
		this.posX = posX;
		this.posY = posY;
		this.velX = velX;
		this.velY = velY;
		this.width = spriteImage.getWidth();
		this.height = spriteImage.getHeight();
		this.id = id;
		isAlive = true;
		
	}
	
	public abstract void update(double timer);
	public abstract void render(GraphicsContext gc, double timer);
	
	/**
	 * returns the bounding box for collision detection
	 * @return Rectangle2D
	 */
	public abstract Rectangle2D getBoundary();
	
	/**
	 * determines collision
	 * @param s
	 * @return boolean
	 */
	public boolean collision(Sprite s) {
		return this.getBoundary().intersects(s.getBoundary());
	}
	
	/**
	 * sets the sprite move by adjusting the velx and vely
	 * @param velX
	 * @param velY
	 */
	public void move(double velX, double velY) {
		this.posX += velX; 
		this.posY += velY;
	}
	
	/**
	 * additional move method for AI moving
	 */
	public abstract void move();
	
	/**
	 * move X direction
	 * @param velX
	 */
	public void moveX(double velX) {
		this.posX += velX;
	}
	
	/**
	 * move Y direction
	 * @param velY
	 */
	public void moveY(double velY) {
		this.posY += velY;
	}
	
	/**
	 * set volecity of a sprite
	 * @param velX
	 * @param velY
	 */
	public void setVelocity(double velX, double velY) {
		this.velX = velX;
		this.velY = velY;
	}
	
	/**
	 * set position of a sprite
	 * @param posX
	 * @param posY
	 */
	public void setPosition(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}

	//SETTERS AND GETTERS
	
	public Id getId() {
		return id;
	}
	
	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Image getSpriteImage() {
		return spriteImage;
	}

	public void setSpriteImage(Image spriteImage) {
		this.spriteImage = spriteImage;
	}
	
	public void setIsAlive(boolean alive) {
		this.isAlive = alive;
	}
	
	public boolean getIsAlive() {
		return isAlive;
	}
	
	

}
