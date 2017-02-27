package networking;

//UDPReceiver.java  
import java.net.*; 

/*
 * Execute UDPReceiver first; then start UDPSender
 */
public class UDPReceiver{  
	public static void main(String[] args) throws Exception {  
		DatagramSocket ds = new DatagramSocket(3334);  
		byte[] buf = new byte[1024];  
		DatagramPacket dp = new DatagramPacket(buf, 1024);  
		System.out.println("Receiving data...");
		ds.receive(dp);  
		String str = new String(dp.getData(), 0, dp.getLength());  
		System.out.println(str);  
		ds.close();  
	}  
}  