package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HostWindowController implements Initializable{
	@FXML
	private ImageView closeBTN;

	@FXML
	private Pane headerP;

	@FXML
	private AnchorPane mainAP;

	@FXML
	private ImageView minimizeBTN;

	@FXML
	private Pane pageP;

	private Stage stage;
	
	
	
	public void setStage(Stage stage) {
		// TODO Auto-generated method stub
		this.stage = stage;
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		closeBTN.setOnMouseClicked(mouseEvent -> stage.close());
		minimizeBTN.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
	}



	public Stage getStage() {
		return this.stage;
	}
}
