package networking;

import java.net.*;
import java.io.*;
/**
 * @author http://lycog.com
 * Example of TCP Object Transmission
Example below is to show you to send MyDate object over the network.
 */
public class TCPObjectClient {
  public static void main(String[] args) {
    Socket socket = null;
    try {
      socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
 
      ObjectInputStream oi =
                   new ObjectInputStream(socket.getInputStream());
 
      //Read serialized object
      MyDate dd = (MyDate) oi.readObject();
 
      //Invoke methods
      System.out.println("MyDate = " + dd.getDate() +
                                " MyNumber = " + dd.getNumber());
    } catch (ClassNotFoundException cnfe) {
      System.out.println(cnfe);
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
  }
}
 