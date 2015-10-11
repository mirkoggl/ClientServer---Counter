package client;

import java.net.*;
import java.io.*;

public class Client {
	private String indirizzo = null;
	private int port = 0;
	private Socket client;
	private DataOutputStream outStream;
	private DataInputStream inStream;
	
	public Client(String sito, int porto) {
		
		indirizzo = sito;
		port = porto;
		
	}
	
	public void connetti() {
		
		try{
			
			System.out.println("Tentativo di connessione a "+indirizzo+":"+port);
			client = new Socket(indirizzo,port);
			
			outStream = new DataOutputStream(client.getOutputStream());
			inStream = new DataInputStream(client.getInputStream());
			System.out.println("Connessione con il server stabilita!");
			
		}
		catch(IOException e){
			System.err.println("Connesisone fallita!");
			e.printStackTrace();
		}
	}
	
	public void todo() {
		int counter = 0;
		
		try{
			
			outStream.writeUTF("Incrementa");
			outStream.writeInt(10);
			System.out.println("Incremento eseguito!");
			
			outStream.writeUTF("Stampa");
			counter = inStream.readInt();
			System.out.println("Counter: "+counter);
			
			outStream.writeUTF("Incrementa");
			outStream.writeInt(100);
			System.out.println("Incremento eseguito!");
			
			outStream.writeUTF("Incrementa");
			outStream.writeInt(20);
			System.out.println("Incremento eseguito!");
			
			outStream.writeUTF("Stampa");
			counter = inStream.readInt();
			System.out.println("Counter: "+counter);
			
			outStream.writeUTF("Ciao");
			
			inStream.close();
			outStream.close();
			client.close();
			System.out.println("Connessione chiusa!");
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
