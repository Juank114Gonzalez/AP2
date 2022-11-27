package connections;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientWorker implements Runnable{

	private Socket socket;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	
	public ClientWorker(Socket socket) throws IOException {
		this.socket = socket;
		this.inputStream = new DataInputStream(this.socket.getInputStream());
		this.outputStream = new DataOutputStream(this.socket.getOutputStream());
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean isConnected = true;
		while (isConnected) {
			try {
				isConnected = this.chooseOptions(isConnected);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private boolean chooseOptions(boolean isConnected) throws IOException {
		
		ServerOptions aux = ServerOptions.valueOf(this.inputStream.readUTF());
		
		switch (aux) {
		case AD_ABOUT_VISIT: 
			adAboutVisit();
			break;
			
		}
		return isConnected;
	}

	private void accept() {
		// TODO Auto-generated method stub
		
	}

	private void deny() {
		// TODO Auto-generated method stub
		
	}

	private void adAboutVisit() throws IOException {
		// TODO Auto-generated method stub
		this.outputStream.writeUTF("You have a visit");
	}

}
