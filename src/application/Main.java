package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private Stage window;
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	private long startTime = System.nanoTime();
	private double timer = 0;
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Monster Game v0.1");
		
		Game game = new Game();
		
		game.init(window);
		
		new AnimationTimer() {
			
			

			@Override
			public void handle(long now) {
				
				timer = (now - startTime)/1000000000;
				
				game.gameUpdate(timer);
				game.gameRender(timer);
				
			}}.start();
		
		window.setResizable(false);
		window.sizeToScene();
		window.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
