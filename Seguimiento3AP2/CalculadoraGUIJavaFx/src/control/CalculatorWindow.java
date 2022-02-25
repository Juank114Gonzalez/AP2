package control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class CalculatorWindow implements Initializable{

	//Variables of OP
	Integer operando1;
	Integer operando2;
	String operation;
	long result;
	String resultString;
	ArrayList<String> historial = new ArrayList<String>();

    //TextElements
    @FXML
    private TextField actualOPTF;
    @FXML
    private TextField resulsTF;
    @FXML
    private Label historialLB;
    @FXML
    private TextArea historialTA;
    
    //Operation Buttons
    @FXML
    private Button divition;
    @FXML
    private Button multiplication;
    @FXML
    private Button plus;
    @FXML
    private Button rest;
    @FXML
    private Button clearButton;


    //Numerical Buttons
    @FXML
    private Button nineButton;
    @FXML
    private Button resultGenerator;
    @FXML
    private Button eightButton;
    @FXML
    private Button sevenButton;
    @FXML
    private Button sixButton;
	@FXML
    private Button fiveButton;
    @FXML
    private Button fourButton;
    @FXML
    private Button threeButton;
    @FXML
    private Button twoButton;
    @FXML
    private Button oneButton;
    @FXML
    private Button zeroButton;
    @FXML
    private Button refreshHistorial;
	
   
    
    
    @FXML
	void pressButton(ActionEvent event) {
		if(event.getSource()== oneButton) {
			clearConsole();
			actualOPTF.setText(actualOPTF.getText()+"1");
		
		}else if(event.getSource()== twoButton) {
			if(actualOPTF.getText().equals("Operación")){clearConsole();}
			actualOPTF.setText(actualOPTF.getText()+"2");
		
		}else if(event.getSource()== threeButton) {
			if(actualOPTF.getText().equals("Operación")){clearConsole();}
			actualOPTF.setText(actualOPTF.getText()+"3");
		
	    }else if(event.getSource()== fourButton) {
	    	if(actualOPTF.getText().equals("Operación")){clearConsole();}
			actualOPTF.setText(actualOPTF.getText()+"4");
			
		}else if(event.getSource()== fiveButton) {
			if(actualOPTF.getText().equals("Operación")){clearConsole();}
			actualOPTF.setText(actualOPTF.getText()+"5");
				
		}else if(event.getSource()== sixButton) {
			if(actualOPTF.getText().equals("Operación")){clearConsole();}
			actualOPTF.setText(actualOPTF.getText()+"6");
				
		}else if(event.getSource()== sevenButton) {
			if(actualOPTF.getText().equals("Operación")){clearConsole();}
			actualOPTF.setText(actualOPTF.getText()+"7");
				
		}else if(event.getSource()== eightButton) {
			if(actualOPTF.getText().equals("Operación")){clearConsole();}
			actualOPTF.setText(actualOPTF.getText()+"8");
				
		}else if(event.getSource()== nineButton) {
			if(actualOPTF.getText().equals("Operación")){clearConsole();}
			actualOPTF.setText(actualOPTF.getText()+"9");
				
		}else if(event.getSource()== zeroButton) {
			if(actualOPTF.getText().equals("Operación")){clearConsole();}
			actualOPTF.setText(actualOPTF.getText()+"0");
		}else if(event.getSource()== plus) {
			operando1 = Integer.parseInt(actualOPTF.getText());
			clearConsole();
			operation = "Suma";
		}else if(event.getSource()== rest) {
			operando1 = Integer.parseInt(actualOPTF.getText());
			clearConsole();
			operation = "Resta";
		}else if(event.getSource()== multiplication) {
			operando1 = Integer.parseInt(actualOPTF.getText());
			clearConsole();
			operation = "Multiplicación";
		}else if(event.getSource()== divition) {
			operando1 = Integer.parseInt(actualOPTF.getText());
			clearConsole();
			operation = "División";
		}else if(event.getSource()== resultGenerator) {
			operando2 = Integer.parseInt(actualOPTF.getText());
			
			switch (operation) {
			case "Suma":
				result = operando1 + operando2;
				resulsTF.setText(String.valueOf(result));
				resultString = (operando1 + " + " + operando2 + " = " + result);
				historial.add(resultString);
				operando1 = 0;
				operando2 = 0;
				result = 0;
				
				break;
			case "Resta":
				result = operando1 - operando2;
				resulsTF.setText(String.valueOf(result));
				resultString = (operando1 + " - " + operando2 + " = " + result);
				historial.add(resultString);
				operando1 = 0;
				operando2 = 0;
				result = 0;
				break;
			case "Multiplicación":
				result = operando1 * operando2;
				resulsTF.setText(String.valueOf(result));
				resultString = (operando1 + " x " + operando2 + " = " + result);
				historial.add(resultString);
				operando1 = 0;
				operando2 = 0;
				result = 0;
				break;
			case "División":
				double resultOfDivition = (double)operando1 / operando2;
				resulsTF.setText(String.valueOf(resultOfDivition));
				resultString = (operando1 + " ÷ " + operando2 + " = " + resultOfDivition);
				historial.add(resultString);
				operando1 = 0;
				operando2 = 0;
				result = 0;
				resultOfDivition = 0;
				break;
			default:
				break;
			}refresh();
		}else if(event.getSource()== clearButton) {
			clearConsole();
			actualOPTF.setText("Operación");
	    	resulsTF.setText("Resultado");
		}else if(event.getSource()== refreshHistorial) {
			refresh();
		}
	}
    
    void clearConsole() {
    	actualOPTF.setText("");
    	resulsTF.setText("");
    }
    
    void refresh() {
    	String historialFull= "";
    	for(String operation: historial){
    		historialFull += (operation + "\n\n");
    	}
    	
    	historialTA.setText(historialFull);
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
	}
}
