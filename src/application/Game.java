package application;

import java.util.Iterator;

import application.control.PlayerMovement;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game {

	private Scene gameScene;
	private Group root;
	private GraphicsContext gc;
	private Canvas canvas;
	private Player player;
	private MonsterHandler mHandler;
	private PlayerMovement pMove;
	

	public Game() {

	}

	/**
	 * Initialize all game objects after Window set scene
	 * 
	 * @param window
	 */
	public void init(Stage window) {

		root = new Group();
		gameScene = new Scene(root, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
		canvas = new Canvas(Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
		gc = canvas.getGraphicsContext2D();

		root.getChildren().add(canvas);

		window.setScene(gameScene);

		// initialize all game objects here
		player = new Player(new Image("textures/King.png"), Main.WINDOW_WIDTH / 2, Main.WINDOW_HEIGHT / 2, 0, 0);

		// initialize monster handler
		mHandler = new MonsterHandler();
		mHandler.init();

		pMove = new PlayerMovement(gameScene);
		

	}

	/**
	 * Game updates
	 * 
	 * @param timer
	 */
	public void gameUpdate(double timer) {

		player.update(timer);
		pMove.playerMove(player);
		mHandler.update(timer);

		if (player.getShoot()) {
			mHandler.getSpriteList().add(new Bullet(ImageLoader.bulletImage, player.getPosX(), player.getPosY(),
					player.getVelX() * 4, player.getVelY() * 4));
		}

		for (Sprite s : mHandler.getSpriteList()) {
			if (s.getId().equals(Id.bullet)) {
				s.move();
			}

		}
		
		for(Sprite s : mHandler.getSpriteList()) {
			if(s.getId() == Id.bullet) {
				for(Sprite m : mHandler.getSpriteList()) {
					if(m.getId() == Id.monster) {
						if(s.collision(m)) m.setIsAlive(false);
					}
				}
			}
		}
		
		
		for(int i = 0; i < mHandler.getSpriteList().size(); i++) {
			Sprite s = mHandler.getSpriteList().get(i);
				if(!s.getIsAlive()) mHandler.getSpriteList().remove(i);
				if(s.getId().equals(Id.bullet)) {
					if(s.getPosX() > Main.WINDOW_WIDTH || s.getPosX() < 0 ||
							s.getPosY() > Main.WINDOW_HEIGHT || s.getPosY() < 0) {
						mHandler.getSpriteList().remove(i);
					}
				}
				
			
		}

	}

	/**
	 * game Render
	 * 
	 * @param timer
	 */
	public void gameRender(double timer) {

		gc.setFill(Color.DARKGRAY);
		gc.fillRect(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);

		player.render(gc, timer);
		mHandler.render(gc, timer);

		for (Sprite s : mHandler.getSpriteList()) {
			if (s.getId().equals(Id.bullet)) {
				gc.drawImage(s.getSpriteImage(), s.getPosX(), s.getPosY());
				//gc.strokeRect(s.getPosX(), s.getPosY(), s.getWidth(), s.getHeight());
			}
		}

	}

}
