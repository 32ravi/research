package networking;

import java.net.*;
import java.io.*;
/**
 * @author http://lycog.com
 * http://lycog.com/java/tcp-object-transmission-java/#more-188
 * Example of TCP Object Transmission
Example below is to show you to send MyDate object over the network.
 *
 */
public class TCPObjectServer {
  public static void main(String[] args) {
    ServerSocket server_socket = null;
    Socket socket = null;
    try {
      server_socket = new ServerSocket(9999);
 
      while (true) {
        System.out.println("Wait for client ....");
        socket = server_socket.accept();
        System.out.println("Accepted from " + socket.getInetAddress());
 
        ObjectOutputStream oo =
                      new ObjectOutputStream(socket.getOutputStream());
 
        MyDate d = new MyDate();
        //Send object over the network
        oo.writeObject(d);
        oo.flush();
      }
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
  }
}