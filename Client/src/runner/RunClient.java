package runner;

import java.util.Scanner;

import connections.ConnectToServer;

public class RunClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectToServer connection = new ConnectToServer();
		Scanner sc = new Scanner(System.in);
		
		String aux = "";
		
		while(!aux.equals("CLOSE")) {
			aux = sc.nextLine();
			
			switch (aux) {
			case "DENY":
				connection.deny();
				break;
			
			case "ACCEPT":
				connection.accept();
				break;
			
			case "PANIC":
				connection.panic();
			}
		}
		sc.close();
	}

}
