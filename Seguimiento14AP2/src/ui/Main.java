package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	private static String root = "data/data.csv";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
	
	}
	
	public static ArrayList<Integer>[] getValuesOfDaysAndAccidents(){
		ArrayList<String> dataSet = readDataSet();
		
		ArrayList<Integer> days = new ArrayList<>();
		
		ArrayList<Integer> accidents = new ArrayList<>();
		
		for(int i = 1; i<dataSet.size();i++) {
			days.add(Integer.parseInt(dataSet.get(i).split(",")[0]));
		}
		
		for(int i = 1; i<dataSet.size();i++) {
			String currentLine = dataSet.get(i).split(",")[1];
			currentLine = currentLine.substring(0, currentLine.length()-1);
			accidents.add(Integer.parseInt(currentLine));
		}
		
		ArrayList<Integer>[] out = new ArrayList[2];
		
		out[0] = days;
		out[1] = accidents;
		
		return out;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/MainWindow.fxml"));

		Parent parent = null;
		try {
			parent = (Parent) loader.load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Stage stage = new Stage();

		Scene scene = new Scene(parent);

		stage.setScene(scene);

		stage.show();
	}
	
	
	
	/**
	 * This method reads the information from a dataset, and saves the information into an
	 * ArrayList
	 * 
	 * @return (String) ArrayList, this is the array with all the information in the
	 *         dataset
	 */
	private static ArrayList<String> readDataSet() {
		ArrayList<String> dataSet = new ArrayList<>();
		// Reads the information from a CSV file
		BufferedReader bf  = null;
		try {
			// Open .csv in buffer's reading mode
			bf = new BufferedReader(new FileReader(root));

			// Read a file line
			String currentLine = bf.readLine();

			// if the line is not empty we keep reading the file
			while (currentLine != null) {
				dataSet.add(currentLine);
				// Read the next file line
				currentLine = bf.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// Close the buffer reader
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return dataSet;
	}






	

}
