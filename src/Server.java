

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
			System.out.println("Server partito...");
			//creo un server socket sulla porta prescelta
			ServerSocket server=new ServerSocket(6789);
			
			//attendo un client
			Socket client=server.accept();
			
			//chiudo il server per inibire altri client
			server.close();
			//input da tastiera
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			//associo lo stream di I/O al socket
			DataInputStream in=new DataInputStream(client.getInputStream());
			//BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
			DataOutputStream out=new DataOutputStream(client.getOutputStream());
			
			String s = " ";
			String stringaLetta= " ";
			do {
				//leggo e visualizzo la risposta
				stringaLetta =in.readLine();
				System.out.println("C:"+stringaLetta);
				
				if(stringaLetta.equals("exit")==false) {
					System.out.print("S:");
					
					s= keyboard.readLine();
					
					//provo a comunicare con il server
					out.writeBytes(s+"\n");
				}
			}while(s.equals("exit")==false && stringaLetta.equals("exit")==false);	

			client.close();

		}
		catch (Exception e){}
	}
}
