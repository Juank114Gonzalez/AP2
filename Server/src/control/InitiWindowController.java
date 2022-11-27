package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import runner.RunServer;

public class InitiWindowController implements Initializable {

	@FXML
	private AnchorPane MainAP;

	@FXML
	private ImageView closeBTN, minimizeBTN;

	@FXML
	private TextField portTF;

	@FXML
	private Button startBTN;

	@FXML
	private Label enterPortLB, pageTittleLB;

	private Stage stage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		closeBTN.setOnMouseClicked(mouseEvent -> stage.close());

		minimizeBTN.setOnMouseClicked(mouseEvent -> stage.setIconified(true));

		startBTN.setOnMouseClicked(mouseEvent -> {
			try {
				RunServer.port = Integer.parseInt(portTF.getText());
				//RunServer.startSever();
				stage.close();
				HostWindowLauncher launcher = new HostWindowLauncher();
				try {
					launcher.start(this.stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NumberFormatException e) {
				AlertsCreator.CreateAlert(AlertType.ERROR, "Port number must be a number", "Invalid port format",
						"Port Error");
			}
		});
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
