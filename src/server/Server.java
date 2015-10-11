package server;

import java.net.*;
import java.io.*;

public class Server {
	private int port = 0;
	private int counter = 0;
	private ServerSocket server;
	private Socket client;
	private DataOutputStream outStream;
	private DataInputStream inStream;
	
	public Server(int porta){
		
		port = porta;
		
		try {
			
			System.out.println("Tento di aprire connessione su port "+port);
			server = new ServerSocket(port);
			System.out.println("In attesa di connessione su port "+port);
			
			} catch (IOException e) {
				System.err.println("Impossibile creare connessione su port: "+port);
				e.printStackTrace();
			}
	}
	
	public void attendi(){
		
		try {
			
			client = server.accept();
			inStream = new DataInputStream (client.getInputStream());
			outStream = new DataOutputStream (client.getOutputStream());
			System.out.println("Connessione con client stabilita!");
			todo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void todo() {
		String command = null;
		
		do{
			try {
				
				command = inStream.readUTF();
				System.out.println("Command: "+command);
				
				if ((command.compareTo("Incrementa")) == 0){
					counter = counter + inStream.readInt();
					System.out.println("Incremento eseguito!");
				}
				else if ((command.compareTo("Stampa")) == 0){
					outStream.writeInt(counter);
					System.out.println("Stampa inviata!");
				}
				else if((command.compareTo("Ciao")) == 0){
					System.out.println("Connessione Terminata!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while((command.compareTo("Ciao")) != 0);
	}
}
