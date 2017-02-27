package networking;

import java.net.*; 

/*
 * Execute UDPReceiver first; then start UDPSender
 */

public class UDPSender{  
	public static void main(String[] args) throws Exception {  
		DatagramSocket ds = new DatagramSocket();  
		String str = "Welcome java";  
		InetAddress ip = InetAddress.getByName("127.0.0.1"); //Value of localhost from InetDemo.java  

		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3334);  
		System.out.println("Sending data....");
		ds.send(dp);  
		ds.close();  
	}  
}  