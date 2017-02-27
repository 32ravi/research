package networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
 
/**
* @author http://lycog.com
 * http://lycog.com/performance-evaluation/tcp-udp-rmi-performance-evaluation/#more-308
 * We develop a simple client server program in Java. 
 * Client sends 100000 messages to server with the size of 10, 15, 20, 25, 30, 35 kilobytes respectivel
 */
public class TCPTransmissionPerformanceClient {
  public static void main(String[] args){
    try{
      int transmittedTime = 100000;
      int n = 5;
      //Vary the message size
      for(int num=0;num<5;num++){
        n = n + 5;
 
        //Repeat the same size for 5 times
        for(int loop=0;loop<5;loop++){
          //Connect to server
          Socket socket = new Socket("127.0.0.1", 8888);
 
          PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
 
          //Prepare message size to be transmitted
          byte[] byteMsg = new byte[1024*n];
          String strMsg = new String(byteMsg);
 
          System.out.println("Start sending messages");
          System.out.println("n=" + n + " loop=" + loop);
          long startTime = System.nanoTime();
          for(int i=0; i<transmittedTime; i++){
            pw.println(strMsg);
          }
          pw.println("quit");
          long endTime = System.nanoTime();
 
          System.out.println("Duration = " + (endTime-startTime));
        }
      }
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }
}