package connections;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectToServer {

	private Socket socket;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	
	public ConnectToServer() {
		
		try {
			this.socket = new Socket("localhost", 2323);
			this.inputStream = new DataInputStream(this.socket.getInputStream());
			this.outputStream = new DataOutputStream(this.socket.getOutputStream());
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String deny() {
		String fromServer = "";
		try {
			this.outputStream.writeUTF(ClientOptions.DENY.toString());
			fromServer = this.inputStream.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fromServer;
	}
	
	public void accept() {
		try {
			this.outputStream.writeUTF(ClientOptions.ACCEPT.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void panic() {
		// TODO Auto-generated method stub
		
	}
	
	
}


