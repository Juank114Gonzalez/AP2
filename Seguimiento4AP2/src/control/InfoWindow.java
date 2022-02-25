package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class InfoWindow implements Initializable{
	
	public static String information;
	
	//Buttons
	@FXML
    private Button changePassBTN;

    @FXML
    private Button closeBoxBTN;

    
    //Text areas
    @FXML
    private TextArea informationTA;

    
    //Anchor pane
    @FXML
    private AnchorPane mainAP;

    
    //Labels
    @FXML
    private Label messageLB;

    @FXML
    private Label titleLB;

	
	//Methods
	public void closeBox(ActionEvent event) throws IOException{  
		LoginWindow.information = informationTA.getText();
		
		FXMLLoader loader = new FXMLLoader(InfoWindow.class.getResource("../ui/LoginWindow.fxml"));
		
		
		loader.setController(new LoginWindow());
		
		Parent parent = (Parent) loader.load();
	
		Stage stage = new Stage();
		
		Scene scene = new Scene(parent);
		
		stage.setScene(scene);
		
		stage.show();
		try {
    		Node source = (Node)event.getSource();
    		Stage old = (Stage) source.getScene().getWindow();
    		old.close();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
	}
	
	public void changePassword(ActionEvent event) throws IOException {
		LoginWindow.information = informationTA.getText();
		
		FXMLLoader loader = new FXMLLoader(InfoWindow.class.getResource("../ui/ChangesWindow.fxml"));
		
		loader.setController(new ChangesWindow());
		
		Parent parent = (Parent) loader.load();
	
		Stage stage = new Stage();
		
		Scene scene = new Scene(parent);
		
		stage.setScene(scene);
		
		stage.show();
		try {
    		Node source = (Node)event.getSource();
    		Stage old = (Stage) source.getScene().getWindow();
    		old.close();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
	}
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
    	informationTA.setText(information);
	}

}
