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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginWindow implements Initializable{

	private String[] passwordCharacters = {"0","1","2","3","4","5","6","7","8","9"};
	
	public static String password = "000000";
	public static String information;
	
    
	//ChoiceBox
	@FXML
    private ChoiceBox<String> firstNumberCB;
	@FXML
    private ChoiceBox<String> secondNumberCB;
	@FXML
    private ChoiceBox<String> thirdNumberCB;
	@FXML
    private ChoiceBox<String> fourthNumberCB;
	@FXML
    private ChoiceBox<String> fifthNumberCB;
	@FXML
    private ChoiceBox<String> sixthNumberCB;

    //AncorPane
	@FXML
    private AnchorPane mainAP;

    //Labels
	@FXML
    private Label messageLB;
    @FXML
    private Label titleLB;
    
    //Buttons
    @FXML
    private Button openBTN;

    //Methods
    public void pressButton(ActionEvent event) {
    	if(((firstNumberCB.getValue() + secondNumberCB.getValue() + thirdNumberCB.getValue() + fourthNumberCB.getValue() + fifthNumberCB.getValue() + sixthNumberCB.getValue())).equals(password)) {
    		try {
				openInfoWindow(event);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Clave de ingreso incorrecta");
    		alert.setHeaderText("Está ingresando mal la clave de acceso a la caja fuerte");
    		alert.setContentText("Verifique que está ingresando la clave de acceso de manera correcta."
    							+ "\n\nAnotación: si es la primera vez que ingresa, digite la clave por defecto 000000 "
    							+ "y a continuacion, en la nueva ventana podrá cambiar la clave de acceso");
    		setValuesOfCBsAsNull();
    		alert.showAndWait();
    	}
    	/*setPassword((firstNumberCB.getValue() + 
    				secondNumberCB.getValue() + 
    				thirdNumberCB.getValue() + 
    				fourthNumberCB.getValue() + 
    				fifthNumberCB.getValue() + 
    				sixthNumberCB.getValue()));*/
    	
    	
    }
    
    private void setValuesOfCBsAsNull() {
		firstNumberCB.setValue(null);
		secondNumberCB.setValue(null);
		thirdNumberCB.setValue(null);
		fourthNumberCB.setValue(null);
		fifthNumberCB.setValue(null);
		sixthNumberCB.setValue(null);
	}
    
    public void openInfoWindow(ActionEvent event) throws IOException {
    	InfoWindow.information = information;
    	
    	FXMLLoader loader = new FXMLLoader(LoginWindow.class.getResource("../ui/InfoWindow.fxml"));
		
		loader.setController(new InfoWindow());
		
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
		setValuesOfCBs();
	}

	private void setValuesOfCBs() {
		firstNumberCB.getItems().addAll(passwordCharacters);
		secondNumberCB.getItems().addAll(passwordCharacters);
		thirdNumberCB.getItems().addAll(passwordCharacters);
		fourthNumberCB.getItems().addAll(passwordCharacters);
		fifthNumberCB.getItems().addAll(passwordCharacters);
		sixthNumberCB.getItems().addAll(passwordCharacters);
		
	}



}
