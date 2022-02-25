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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChangesWindow implements Initializable{

	private String[] passwordCharacters = {"0","1","2","3","4","5","6","7","8","9"};
	
	//Buttons
	@FXML
    private Button changePassBTN;

    @FXML
    private Button closeBoxBTN;

   
    //Choice Boxes
    @FXML
    private ChoiceBox<String> fifthNumberCB;

    @FXML
    private ChoiceBox<String> fifthNumberNewPassCB;

    @FXML
    private ChoiceBox<String> firstNumberCB;

    @FXML
    private ChoiceBox<String> firstNumberNewPassCB;

    @FXML
    private ChoiceBox<String> fourthNumberCB;

    @FXML
    private ChoiceBox<String> fourthNumberNewPassCB;
    
    @FXML
    private ChoiceBox<String> secondNumberCB;

    @FXML
    private ChoiceBox<String> secondNumberNewPassCB;

    @FXML
    private ChoiceBox<String> sixthNumberCB;

    @FXML
    private ChoiceBox<String> sixthNumberNewPassCB;

    @FXML
    private ChoiceBox<String> thirdNumberCB;

    @FXML
    private ChoiceBox<String> thirdNumberNewPassCB;
    
    
    //Anchor pane
    @FXML
    private AnchorPane mainAP;

    
    //Labels
    @FXML
    private Label messageLB;

    @FXML
    private Label messageLB1;

    @FXML
    private Label titleLB;

    
    
    //Methods
    
    @FXML
    void changePassword(ActionEvent event) {
    	if(LoginWindow.password.equals(firstNumberCB.getValue()+secondNumberCB.getValue()+thirdNumberCB.getValue()+
    								   fourthNumberCB.getValue()+fifthNumberCB.getValue()+sixthNumberCB.getValue())) {
    		LoginWindow.password = firstNumberNewPassCB.getValue()+secondNumberNewPassCB.getValue()+thirdNumberNewPassCB.getValue()+
					   			   fourthNumberNewPassCB.getValue()+fifthNumberNewPassCB.getValue()+sixthNumberNewPassCB.getValue();
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Actualización de clave!");
    		alert.setHeaderText(null);
    		alert.setContentText("La clave de acceso ha sido cambiada con éxito");
    		try {
				closeBox(event);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		alert.showAndWait();
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Clave de actual incorrecta");
    		alert.setHeaderText("Está ingresando mal la clave de acceso actual a la caja fuerte");
    		alert.setContentText("Verifique que está ingresando la clave de acceso actual de manera correcta."+
    							"\nAnotación: si es la primera vez que cambia la clave, digite la clave por defecto 000000");
    		setValuesOfCBsAsNull();
    		alert.showAndWait();
    	}
    }

    @FXML
    void closeBox(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(ChangesWindow.class.getResource("../ui/LoginWindow.fxml"));
		
		
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setValuesOfCBs();
	}

	private void setValuesOfCBsAsNull() {
		firstNumberCB.setValue(null);
		secondNumberCB.setValue(null);
		thirdNumberCB.setValue(null);
		fourthNumberCB.setValue(null);
		fifthNumberCB.setValue(null);
		sixthNumberCB.setValue(null);
		firstNumberNewPassCB.setValue(null);
		secondNumberNewPassCB.setValue(null);
		thirdNumberNewPassCB.setValue(null);
		fourthNumberNewPassCB.setValue(null);
		fifthNumberNewPassCB.setValue(null);
		sixthNumberNewPassCB.setValue(null);
	}
	
	private void setValuesOfCBs() {
		firstNumberCB.getItems().addAll(passwordCharacters);
		secondNumberCB.getItems().addAll(passwordCharacters);
		thirdNumberCB.getItems().addAll(passwordCharacters);
		fourthNumberCB.getItems().addAll(passwordCharacters);
		fifthNumberCB.getItems().addAll(passwordCharacters);
		sixthNumberCB.getItems().addAll(passwordCharacters);
		firstNumberNewPassCB.getItems().addAll(passwordCharacters);
		secondNumberNewPassCB.getItems().addAll(passwordCharacters);
		thirdNumberNewPassCB.getItems().addAll(passwordCharacters);
		fourthNumberNewPassCB.getItems().addAll(passwordCharacters);
		fifthNumberNewPassCB.getItems().addAll(passwordCharacters);
		sixthNumberNewPassCB.getItems().addAll(passwordCharacters);
	}
	
}
