package networking;

import java.net.*;  
import java.io.*;  

/*Works with TCPServer2
 * In this example, client will write first to the server then server will receive and print the text. 
 * Then server will write to the client and client will receive and print the text. The step goes on.
 * 
 */

class TCPClient2{  
	public static void main(String args[])throws Exception{  
		Socket s=new Socket("localhost",3333); //Note TCPServer2 has ServerSocket class 
		System.out.println("Client window");
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

		String str="",str2="";  
		while(!str.equals("stop")){  
			str=br.readLine();  
			dout.writeUTF(str);  
			dout.flush();  
			str2=din.readUTF();  
			System.out.println("Server says: "+str2);  
		}  

		dout.close();  
		s.close();  
		System.out.print("Client Closing connections!!!");

	}}  