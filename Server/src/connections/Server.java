package connections;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import control.AlertsCreator;
import javafx.scene.control.Alert.AlertType;
import runner.RunServer;

public class Server {

	private ServerSocket serverSocket;

	private ArrayList<Thread> apartments;

	public Server() {
		this.apartments = new ArrayList<Thread>();
		Integer port = RunServer.port;
		try {
			this.serverSocket = new ServerSocket(port);
			
			System.out.println("El puerto es " + port);
			
		} catch (IllegalArgumentException e) {
			if ((port < 1) || (port > (Math.pow(2, 16) - 1))) {
				AlertsCreator.CreateAlert(AlertType.ERROR, "Port number must be between 1 & 65535.",
						"Invalid port number", "Port Error");
			}
		} catch (IOException e){
			if (port == null) {
				AlertsCreator.CreateAlert(AlertType.ERROR, "Entry any port number please!", "Empty port number field",
						"Port Error");
			 }
		}

	}

	public void startToListen() throws IOException {
		while (true) {
			System.out.println("1");
			
			Socket client = this.serverSocket.accept();

			System.out.println("2");
			Thread auxAp = new Thread(new ClientWorker(client));

			System.out.println("3");
			auxAp.start();

			System.out.println("4");
			this.apartments.add(auxAp);
		}
	}

}
