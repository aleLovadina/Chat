

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
			System.out.println("Server started...");
			//server socket on the chosen port
			ServerSocket server=new ServerSocket(6789);
			
			//waiting for a client
			Socket client=server.accept();
			
			//closing the server so no other clients can connect to the same port
			server.close();
			//keyboard input
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			//I/O stream on server socket
			DataInputStream in=new DataInputStream(client.getInputStream());
			//BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
			DataOutputStream out=new DataOutputStream(client.getOutputStream());
			
			String s = " ";
			String readString= " ";
			do {
				//reading and visualize the response
				readString =in.readLine();
				System.out.println("C:"+readString);
				
				if(readString.equals("exit")==false) {
					System.out.print("Server:");
					
					s= keyboard.readLine();
					
					//trying to communicate to the client
					out.writeBytes(s+"\n");
				}
			}while(s.equals("exit")==false && readString.equals("exit")==false);	

			client.close();

		}
		catch (Exception e){}
	}
}
