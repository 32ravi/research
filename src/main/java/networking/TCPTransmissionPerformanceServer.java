package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
 
/**
 *
 * @author http://lycog.com
 * http://lycog.com/performance-evaluation/tcp-udp-rmi-performance-evaluation/#more-308
 * We develop a simple client server program in Java. 
 * Client sends 100000 messages to server with the size of 10, 15, 20, 25, 30, 35 kilobytes respectivel
 * 
 * Conclusion
RMI is easy to implement large scale distributed systems but if the system requires a lot of exchanging messages, 
then it is not recommended. Even though UDP slightly performs better than TCP, it is not recommended for accurately 
demand application. It is better for live conference, multimedia, discovery services etc. 
TCP, on the other hand, is good if we deal with a lot of exchanging messages.
 */
public class TCPTransmissionPerformanceServer {
  public static void main(String[] args){
    try{
      ServerSocket server = new ServerSocket(8888);
 
      while(true){
        System.out.println("Server starts listening...");
        Socket socket = server.accept();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
 
        String msg = "";
        while(true){
          msg = br.readLine();
          if(msg.equals("quit")) break;
        }
      }
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }
}