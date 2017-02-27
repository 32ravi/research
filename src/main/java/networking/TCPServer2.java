package networking;

import java.net.*;  
import java.io.*;  

/*Works with TCPClient2
 * In this example, client will write first to the server then server will receive and print the text. 
 * Then server will write to the client and client will receive and print the text. The step goes on.
 * 
 */
class TCPServer2{  
	public static void main(String args[])throws Exception{  
		
		ServerSocket ss=new ServerSocket(3333); //Client will instead have an instance of Socket class
		                //THis will i) create a socket and ii)bind the socket to specified port
		System.out.println("Server windos:");
		
		Socket s=ss.accept();  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

		String str="",str2="";  
		while(!str.equals("stop")){  
			str=din.readUTF();  
			System.out.println("client says: "+str);  
			str2=br.readLine();  
			dout.writeUTF(str2);  
			dout.flush();  
		}  
		din.close();  
		s.close();  
		ss.close(); 
		System.out.print("Server Closing connections!!!");
	}}  