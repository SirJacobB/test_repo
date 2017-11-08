package test_repo;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class main extends Application{
	
	public static final double WORLD_WIDTH = 500;
	public static final double WORLD_HEIGHT = 500;
	
	Group root = new Group();
	Scene scene = new Scene(root, WORLD_WIDTH, WORLD_HEIGHT);
	
//	private Circle cir = new Circle(WORLD_WIDTH/50);
	private double playerRadius = (((WORLD_WIDTH+WORLD_HEIGHT)/2)/30);
	private Player player = new Player(playerRadius);
	
	private ArrayList<KeyCode> keys = new ArrayList<KeyCode>();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		createCircle();
		eventListener();
		
		primaryStage.setTitle("Circle");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void createCircle() {
		
//		player.setFill(Color.rgb(230, 36, 140));
		player.setTranslateX(WORLD_WIDTH/2);
		player.setTranslateY(WORLD_HEIGHT/2);
		
		root.getChildren().addAll(player);
	}
	
	private void eventListener() {
		scene.setOnKeyPressed(event->{
			if(!keys.contains(event.getCode())){
				keys.add(event.getCode());
			}
		});
		
		scene.setOnKeyReleased(event->{
			if(keys.contains(event.getCode())){
				keys.remove(event.getCode());
			}
		});
		
		
		AnimationTimer at = new AnimationTimer() {

			double moveTimer = 0;
			
			@Override
			public void handle(long now) {
				
				if(now - moveTimer >= 1000000) {
					moveTimer = now;
					if(keys.contains(KeyCode.W)) {
						player.setTranslateY(player.getTranslateY()-(playerRadius/5));
					}
					if(keys.contains(KeyCode.A)) {
						player.setTranslateX(player.getTranslateX()-(playerRadius/5));
					}
					if(keys.contains(KeyCode.S)) {
						player.setTranslateY(player.getTranslateY()+(playerRadius/5));
					}
					if(keys.contains(KeyCode.D)) {
						player.setTranslateX(player.getTranslateX()+(playerRadius/5));
					}
				}
			}
		};	
		at.start();
	}
}
