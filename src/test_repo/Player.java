package test_repo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player extends Circle{

	public Player(double radius) {
		
		this.setRadius(radius);
		
		this.setFill(Color.rgb((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
	}
}