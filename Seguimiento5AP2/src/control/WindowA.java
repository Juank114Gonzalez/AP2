package control;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Transaccion;
import model.TransaccionData;

public class WindowA implements Initializable{

	private String[] types = { "GASTO", "INGRESO" };
	
	@FXML
	private Button acceptBTN;

	@FXML
	private TextField dateTF;

	@FXML
	private TextArea descTF;

	@FXML
	private TextField typeTF;

	@FXML
	private ChoiceBox<String> typeCB;

	@FXML
	private TextField valueTF;

	@FXML
	private Button addBTN;

	@FXML
	private TextField balanceTF;

	@FXML
	private TableColumn<?, ?> dateCol;

	@FXML
	private DatePicker dateDP;

	@FXML
	private Button deleteBTN;

	@FXML
	private TableColumn<?, ?> descriptionCol;

	@FXML
	private TextField descriptionTF;

	@FXML
	private TextField expensesTF;

	@FXML
	private DatePicker higherDateDP;

	@FXML
	private DatePicker inferiorDateDP;

	@FXML
	private TextField infoundTF;

	@FXML
	private TableView<?> movesTable;

	@FXML
	private TableColumn<?, ?> nameCol;

	@FXML
	private TableColumn<?, ?> typeCol;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		completeCBs();
	}

	void addQuantity(ActionEvent event) throws ParseException{
		do{
			if(!confirmDouble(valueTF.getText())) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error al ingresar el valor!");
		        alert.setContentText("Ha digitado un valor no válido");
		        Optional<ButtonType> result = alert.showAndWait();
			}
		
		valueTF.getText();
		descriptionTF.getText();
		typeCB.getValue();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date fdate = new Date();
		fdate = date.parse(dateDP.getAccessibleText());
		}while(!confirmDouble(valueTF.getText()));
		
		TransaccionData.data.add(new Transaccion(valueTF.getText();, null, null, null));
	}
	
	
	public void completeCBs() {
		typeCB.getItems().addAll(types);
	}

	

	/**
	 * Verifica que una cadena pueda pasarse a tipo double
	 * 
	 * @param value, String, cadena que se revisa
	 * @return out, boolean, true si la cadena puede pasarse a double, false de lo
	 *         contrario
	 */
	public boolean confirmDouble(String value) {

		boolean out = true;
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) != '.' && value.charAt(i) != '1' && value.charAt(i) != '2' && value.charAt(i) != '3'
					&& value.charAt(i) != '4' && value.charAt(i) != '5' && value.charAt(i) != '6'
					&& value.charAt(i) != '7' && value.charAt(i) != '8' && value.charAt(i) != '9'
					&& value.charAt(i) != '0') {
				out = false;
				break;
			}
		}
		return out;
	}

	/**
	 * Limpia todos los text field de la interfaz
	 */
	public void clear() {
		dateTF.setText("");
		descTF.setText("");
		valueTF.setText("");
		typeTF.setText("");
	}

}
