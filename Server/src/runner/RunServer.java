package runner;

import java.io.IOException;

import connections.Server;
import control.InitWindowLauncher;

public class RunServer {

	public static Integer port;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InitWindowLauncher launcher = new InitWindowLauncher();
		launcher.run();
		
		if(port.equals(null)) {
			System.out.println("a");
		}else {
			startSever();
		}
		
	}
	
	public static void startSever() {
		try {
			new Server().startToListen();
			System.out.println(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
