package application;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class ImageLoader {
	
	public ImageLoader() {
		
	}
	
	private static Image austinMonster = new Image("textures/AustinMonsters.png");
	public static WritableImage monster1 = new WritableImage(austinMonster.getPixelReader(),0,0,32,32);
	public static WritableImage monster2 = new WritableImage(austinMonster.getPixelReader(),32,0,32,32);
	
	private static Image jordanMonster = new Image("textures/JordanMonsters.png");
	public static WritableImage monster3 = new WritableImage(jordanMonster.getPixelReader(), 0, 0 ,32, 32);
	public static WritableImage monster4 = new WritableImage(jordanMonster.getPixelReader(), 32, 0 , 32, 32);
	
	public static Image bulletImage = new Image("textures/bullet.png");
	
	public static void loadImages() {
		
	}

}
