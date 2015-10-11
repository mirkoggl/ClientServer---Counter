package client;

public class MainClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client c = new Client("127.0.0.1",8000);
		c.connetti();
		c.todo();

	}

}
