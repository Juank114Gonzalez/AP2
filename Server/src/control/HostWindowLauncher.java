package control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HostWindowLauncher{


	public void start(Stage stage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/HostWindow.fxml"));
        		
		HostWindowController controller = new HostWindowController();
		
		controller.setStage(stage);
		
		loader.setController(controller );
		
		Parent parent = (Parent) loader.load();
		
		Scene scene = new Scene(parent);
        
        scene.setFill(Color.TRANSPARENT);
        
        stage.setScene(scene);
        
        stage.initStyle(StageStyle.TRANSPARENT);
        
		stage.setScene(scene);
		
		stage.setResizable(false);
				
		
		stage.show();
	}
	
	
}
