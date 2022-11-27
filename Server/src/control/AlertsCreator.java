package control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * THis class is an Alerts Constructor
 * 
 * @author Juan Camilo González
 *
 */
public class AlertsCreator {

	/**
	 * This method build an alert
	 * 
	 * @param type    AlertType, it can be:- <b>NONE</b> - <b>INFORMATION</b> -
	 *                <b>WARNING</b> - <b>CONFIRMATION</b> - <b>ERROR</b>
	 * @param content String, it's the <b>information/description</b> of alert.
	 * @param header  String, it's the <b>header</b> of alert.
	 * @param title   String, it's the <b>title</b> of alert.
	 */
	public static void CreateAlert(AlertType type, String content, String header, String title) {
		Alert alert = new Alert(type);

		alert.setContentText(content);
		alert.setHeaderText(header);
		alert.setTitle(title);

		alert.showAndWait();
	}

}
