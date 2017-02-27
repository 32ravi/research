package networking;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
 
/**
 *
 * @author http://lycog.com
 * http://lycog.com/performance-evaluation/tcp-udp-rmi-performance-evaluation/#more-308
 * We develop a simple client server program in Java. 
 * Client sends 100000 messages to server with the size of 10, 15, 20, 25, 30, 35 kilobytes respectivel
 */

public class UDPPerformanceClient {
  public static void main(String[] args){
    try{
      int n = 5;
      for(int num=0;num<5;num++){
        System.out.println("----------------------");
        n = n + 5;
        for(int loop=0;loop<5;loop++){
          DatagramSocket socket = new DatagramSocket();
          InetAddress serverIp = InetAddress.getByName("127.0.0.1");
          int PORT = 8887;
          int transmittedTime = 100000;
          int count = 0;
          byte[] byteMsg = new byte[1024*n];
          byte[] command;
 
          System.out.println("n=" + n + " loop=" + loop);
          command = ("" + n).getBytes();
          sendPacket(socket, command, serverIp, PORT);
 
          long startTime = System.nanoTime();
          while(true){
            for(int i=count; i<transmittedTime; i++){
              sendPacket(socket, byteMsg, serverIp, PORT);
              sleep(0);
            }
            //Send notification whether it is complete
            System.out.println("Send check count command");
            command = "count".getBytes();
            sendPacket(socket, command, serverIp, PORT);
            sleep(0);
 
            System.out.println("Receiving count...");
            String strCount = receivePacket(socket);
            count = Integer.parseInt(strCount);
            System.out.println("Count = " + count);
            if(count==transmittedTime) {
              //Send quit command to terminate
              System.out.println("Send quits command");
              byte[] quit = "quit".getBytes();
              sendPacket(socket, quit, serverIp, PORT);
              sleep(0);
              break;
            }
          }
 
          long stopTime = System.nanoTime();
 
          System.out.println("Duration = " + (stopTime-startTime));
        }
      }
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
  }
 
  private static String receivePacket(DatagramSocket socket){
    byte[] byteRecv = new byte[1024];
    String msg = "";
    try{
      DatagramPacket inPacket = new DatagramPacket(byteRecv,
              0, byteRecv.length);
      socket.receive(inPacket);
      msg = new String(byteRecv, 0, inPacket.getLength());
    }catch(IOException ioe){
      ioe.printStackTrace();
    }
    return msg;
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