package test_repo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application{
	
	public static final double WORLD_WIDTH = 500;
	public static final double WORLD_HEIGHT = 500;
	
	Group root = new Group();
	Scene scene = new Scene(root, WORLD_WIDTH, WORLD_HEIGHT);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
