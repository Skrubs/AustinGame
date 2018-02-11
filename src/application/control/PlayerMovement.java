package application.control;

import java.util.ArrayList;

import application.Player;
import javafx.scene.Scene;

public class PlayerMovement {

	private ArrayList<String> inputList = new ArrayList<>();
	private Scene scene;

	public PlayerMovement(Scene scene) {
		this.scene = scene;
	}

	public void playerMove(Player player) {
		scene.setOnKeyPressed(e -> {
			String code = e.getCode().toString();
			if (!inputList.contains(code))
				inputList.add(code);
		});

		scene.setOnKeyReleased(e -> {
			String code = e.getCode().toString();
			if (inputList.contains(code))
				inputList.remove(code);
		});

		if (inputList.contains("W")) {
			
			player.setVelY(-2);
		}else if(player.getVelY() < 0) {
			player.setVelY(0);
		}
		if (inputList.contains("S")) {
			player.setVelY(2);
		}else if(player.getVelY() > 0) {
			player.setVelY(0);
		}
		if (inputList.contains("A")) {
			player.setVelX(-2);
		}else if(player.getVelX() < 0) {
			player.setVelX(0);
		}
		if (inputList.contains("D")) {
			player.setVelX(2);
		}else if(player.getVelX() > 0) {
			player.setVelX(0);
		}
		if(inputList.contains("SPACE")) {
			player.setShoot(true);
		}else if(!inputList.contains("SPACE")){
			player.setShoot(false);
		}
		
	}

}
