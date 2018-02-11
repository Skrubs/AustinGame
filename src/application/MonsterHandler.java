package application;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

public class MonsterHandler {
	
	private ArrayList<Sprite> spriteList = new ArrayList<>();
	private Random gen = new Random();
	
	
	public MonsterHandler() {
		
	}
	
	public void init() {
		for(int i = 0; i < 10; i++) {
			spriteList.add(new GreenMonster(ImageLoader.monster1,gen.nextInt(800), gen.nextInt(600), gen.nextDouble(), gen.nextDouble()));
			spriteList.add(new BlueMonster(ImageLoader.monster2,gen.nextInt(800), gen.nextInt(600), gen.nextDouble(), gen.nextDouble()));
			spriteList.add(new PinkMonster(ImageLoader.monster3,gen.nextInt(800), gen.nextInt(600), gen.nextDouble(), gen.nextDouble()));
			spriteList.add(new OrangeMonster(ImageLoader.monster4,gen.nextInt(800), gen.nextInt(600), gen.nextDouble(), gen.nextDouble()));


		}
		
	
		
		
	}
	
	public void update(double timer) {
		for(Sprite s : spriteList) {
			s.update(timer);
		}
	}
	
	public void render(GraphicsContext gc, double timer) {
		for(Sprite s : spriteList) {
			
			gc.drawImage(s.getSpriteImage(), s.getPosX(), s.getPosY());
			//gc.strokeRect(s.getPosX(), s.getPosY(), s.getWidth(), s.getHeight());
		}
	}
	
	public ArrayList<Sprite> getSpriteList(){
		return spriteList;
	}

}
