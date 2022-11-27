package control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class InitWindowLauncher extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/InitWindow.fxml"));
        		
		InitiWindowController initWindowController = new InitiWindowController();
		
		loader.setController(initWindowController );
		
		Parent parent = (Parent) loader.load();
		
		Scene scene = new Scene(parent);
        
        scene.setFill(Color.TRANSPARENT);
        
        stage.setScene(scene);
        
        stage.initStyle(StageStyle.TRANSPARENT);
        
		stage.setScene(scene);
		
		stage.setResizable(false);
				
		initWindowController.setStage(stage);
		
		stage.show();
	}
	
	public void run(){ launch(); }

}
