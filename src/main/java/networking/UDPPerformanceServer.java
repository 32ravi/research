package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
 
/**
 *
 * @author http://lycog.com
 * http://lycog.com/performance-evaluation/tcp-udp-rmi-performance-evaluation/#more-308
 * We develop a simple client server program in Java. 
 * Client sends 100000 messages to server with the size of 10, 15, 20, 25, 30, 35 kilobytes respectively
 *  * Conclusion
RMI is easy to implement large scale distributed systems but if the system requires a lot of exchanging messages, 
then it is not recommended. Even though UDP slightly performs better than TCP, it is not recommended for accurately 
demand application. It is better for live conference, multimedia, discovery services etc. 
TCP, on the other hand, is good if we deal with a lot of exchanging messages.

 */
public class UDPPerformanceServer {
  public static void main(String[] args){
    try{
      DatagramSocket server = new DatagramSocket(8887);
      DatagramPacket inPacket = null;
      DatagramPacket outPacket = null;
      int count = 0;
      int n = 0;
      byte[] command;
      String strCommand;
      int clientPort;
      InetAddress clientIp;
      while(true){
        System.out.println("Waiting for client...");
        command = new byte[256];
        inPacket = new DatagramPacket(command, 0, command.length);
        server.receive(inPacket);
        strCommand = new String(command, 0, inPacket.getLength());
        n = Integer.parseInt(strCommand);
        //get client port
        clientPort = inPacket.getPort();
        //get client IP address
        clientIp = inPacket.getAddress();
        System.out.println("Receiving byte = " + n + "*1024");
 
        while(true){
          byte[] inBuf = new byte[1024*n];
          inPacket = new DatagramPacket(inBuf, inBuf.length);
          server.receive(inPacket);
 
          //Check if it is correct size
          if(inPacket.getLength()==(n*1024)){
            count++;
          }
          String msg = new String(inPacket.getData(), 0, inPacket.getLength());
 
          //If client requests for received packets
          if(msg.equals("count")){
            command = ("" + count).getBytes();
            sendPacket(server, command, clientIp, clientPort);
            System.out.println("Number of receiving packet = " + count);
            sleep(0);
          }
 
          //If client requests termination
          if(msg.equals("quit")) {
            count = 0;
            System.out.println("client terminated");
            System.out.println("-------------------------");
            break;
          }
        }
      }
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }
 
  private static void sendPacket(DatagramSocket socket,
          byte[] msg, InetAddress ip, int port){
    try{
      DatagramPacket outPacket = new DatagramPacket(msg,
              0, msg.length, ip, port);
      socket.send(outPacket);
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }
 
  private static void sleep(int millisecond){
    try {
      Thread.sleep(millisecond, 1);
    } catch (InterruptedException ie) {
      ie.printStackTrace();
    }
  }
}