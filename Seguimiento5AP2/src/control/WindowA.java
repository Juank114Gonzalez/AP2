package control;

import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Transaccion;
import model.TransaccionData;
import model.Type;

public class WindowA implements Initializable {

	private String[] types = { "GASTO", "INGRESO" };
	
	// Buttons
	@FXML
	private Button acceptBTN;
	@FXML
	private Button addBTN;
	@FXML
	private Button deleteBTN;
	@FXML
	private Button applyFilterBTN;
	@FXML
	private Button addBalance;

	
	// Table View
	@FXML
	private TableView<Transaccion> movesTable;
	@FXML
	private TableColumn<Transaccion, String> valueCol;
	@FXML
	private TableColumn<Transaccion, Type> typeCol;
	@FXML
	private TableColumn<Transaccion, String> descriptionCol;
	@FXML
	private TableColumn<Transaccion, LocalDate> dateCol;

	
	// Text Fields
	@FXML
	private TextField descTF;
	@FXML
	private TextField valueTF;
	@FXML
	private TextField balanceTF = new TextField();
	@FXML
	private TextField expensesTF = new TextField();
	@FXML
	private TextField incomesTF = new TextField();

	// Choice Box
	@FXML
	private ChoiceBox<String> typeCB;

	// Date Picker
	@FXML
	private DatePicker higherDateDP;
	@FXML
	private DatePicker inferiorDateDP;
	@FXML
	private DatePicker dateDP;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		// Filling the choice box of types
		fillTypeCB();

		// Initialization of the columns in the table view
		valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
		typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
		descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
	}

	@FXML
	void addQuantity(ActionEvent event) throws ParseException {
		Type tipoValor = Type.GASTO;

		// Gets the values from the scene builder interface
		String valor = "";
		Double valorDouble = 0.0;
		String descripcion = descTF.getText();
		String tipo = typeCB.getValue();
		LocalDate fecha = dateDP.getValue();
		// Validations of the date types and classes
		if (confirmDouble(valueTF.getText())) {
			valor = valueTF.getText();
			valorDouble = Double.parseDouble(valor);
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error de tipo de dato");
			alert.setContentText(
					"El número ingresado no cuenta con el formato de tipo decimal (Use \".\" como separador)");
			Optional<ButtonType> result = alert.showAndWait();
		}

		// sets the type according the enumeration class "Type"
		if (tipo.equals("INGRESO")) {
			tipoValor = Type.INGRESO;
		}

		TransaccionData.data.add(new Transaccion(valorDouble, descripcion, tipoValor, fecha));
		movesTable.setItems(TransaccionData.data);
		clear();
		showBalance(event, TransaccionData.data);
	}
	
    void showBalance(ActionEvent event, ObservableList<Transaccion> data) {
		Double expenses = 0.0;
		Double incomes = 0.0;
		
		for(Transaccion t : data) {
			if(t.getType().equals(Type.GASTO)) {
				expenses += t.getValue();
			}else {
				incomes += t.getValue();
			}
		}
		
		Double balance = incomes - expenses;
		
		incomesTF.setText(""+incomes);
		expensesTF.setText(""+expenses);
		balanceTF.setText(""+balance);
    }
	
	@FXML
	void applyFilter(ActionEvent event) {
		ObservableList<Transaccion> filteredListPerDate = FXCollections.observableArrayList();
		
		LocalDate lowerDate = inferiorDateDP.getValue();
		
		LocalDate higherDate = higherDateDP.getValue();
		
		for(Transaccion t : TransaccionData.data) {
			if ((t.getDate().isAfter(lowerDate) || t.getDate().equals(lowerDate)) 
				&& (t.getDate().isBefore(higherDate) || t.getDate().equals(higherDate))) {
				
				filteredListPerDate.add(t);
			
			}
		}
		
		movesTable.setItems(filteredListPerDate);
		showBalance(event, filteredListPerDate);
	}

	@FXML
	void undoFilter(ActionEvent event) {
		movesTable.setItems(TransaccionData.data);
		showBalance(event, TransaccionData.data);
	}

	
	@FXML
	void deleteElement(ActionEvent event) {
		Transaccion p = (Transaccion) movesTable.getSelectionModel().getSelectedItem();
        TransaccionData.data.remove(p);
	}
	
	
	/**
	 * 
	 */
	public void fillTypeCB() {
		typeCB.getItems().addAll(types);
	}

	/**
	 * Verifies that a string can be passed to type double
	 * 
	 * @param value, String, string being checked
	 * @return out, boolean, true true if string can be passed to double, false
	 *         otherwise
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
	 * Clears all the text fields
	 */
	public void clear() {
	
		if(dateDP != null) {
			dateDP.setValue(null);
		}
		
		if(descTF != null) {
			descTF.clear();
		}
		
		if(valueTF != null) {
			valueTF.clear();
		}
		
		if(typeCB != null) {
			typeCB.setValue(null);
		}
	}

}