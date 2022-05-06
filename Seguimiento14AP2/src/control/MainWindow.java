package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import ui.Main;

public class MainWindow implements Initializable {

	private ArrayList<Integer> days;

	private ArrayList<Integer> accidents;

	@FXML
	private Canvas canvas;

	private GraphicsContext gracphicsContext;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		days.addAll(Main.getValuesOfDaysAndAccidents()[0]);
		accidents.addAll(Main.getValuesOfDaysAndAccidents()[1]);

		gracphicsContext = canvas.getGraphicsContext2D();

		paintBackground();
		
		paintPoint(150.0,250.0);
	}

	private void paintBackground() {
		// TODO Auto-generated method stub
		// Fondo
		gracphicsContext.setFill(Color.MINTCREAM);
		gracphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

	void paintPoint(double x, double y) {

		// Círculo
		gracphicsContext.setFill(Color.PURPLE);
		gracphicsContext.fillOval(x, y, 10, 10);

		// Borde del círculo
		gracphicsContext.setStroke(Color.BLUEVIOLET);
		gracphicsContext.strokeOval(x, y, 10, 10);

	}
}
