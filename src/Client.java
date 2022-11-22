//ReadBeforeUsing: the first message needs to be sent by the client, then the server can reply and so on
//both client and server processes terminate when any of them writes: exit



import java.io.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try{
			System.out.println("Client started...");
			//keyboard input
			//BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			Scanner scanner=new Scanner (System.in);
			//socket creation
			Socket client=new Socket("localhost",6789);
			
			//streams to read and write using the socket
			DataOutputStream out=new DataOutputStream (client.getOutputStream());
			DataInputStream in=new DataInputStream(client.getInputStream());
			
			String c = " ";
			String readString= " ";
			do {
				
				//c= keyboard.readLine();
				System.out.print("Client:");
				c=scanner.nextLine();
				
				//try to communicate with the server
				out.writeBytes(c+"\n");
				
				if(c.equals("exit")==false) {
					//leggo e visualizzo la risposta
					
					readString =in.readLine();  //deprecated
					//readString=in.readUTF();  //doesn't work!?	
					System.out.println("S:"+readString);
				}			
			}while(c.equals("exit")==false && readString.equals("exit")==false);
			
			//closing the connection
			client.close();
		}
		catch (Exception e){
		}
	}
}

