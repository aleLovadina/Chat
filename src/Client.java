//NB: deve iniziare il client; segue risposta del server e via di seguito 
//termina quando uno dei due scrive: exit



import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try{
			System.out.println("Client partito...");
			//input da tastiera
			//BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			Scanner scanner=new Scanner (System.in);
			//creo il socket
			Socket client=new Socket("localhost",6789);
			
			//associo gli stream per leggere e scrivere sul socket
			DataOutputStream out=new DataOutputStream (client.getOutputStream());
			DataInputStream in=new DataInputStream(client.getInputStream());
			
			String c = " ";
			String stringaLetta= " ";
			do {
				
				//c= keyboard.readLine();
				System.out.print("C:");
				c=scanner.nextLine();
				
				//provo a comunicare con il server
				out.writeBytes(c+"\n");
				
				if(c.equals("exit")==false) {
					//leggo e visualizzo la risposta
					
					stringaLetta =in.readLine();  //deprecato
					//stringaLetta=in.readUTF();  //non funziona!?	
					System.out.println("S:"+stringaLetta);
				}			
			}while(c.equals("exit")==false && stringaLetta.equals("exit")==false);
			
			//chiudo la connessione
			client.close();
		}
		catch (Exception e){
		}
	}
}

