package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
 
/**
*
* @author http://lycog.com
* http://lycog.com/performance-evaluation/tcp-udp-rmi-performance-evaluation/#more-308
* We develop a simple client server program in Java. 
* Client sends 100000 messages to server with the size of 10, 15, 20, 25, 30, 35 kilobytes respectivel
*  * Conclusion
RMI is easy to implement large scale distributed systems but if the system requires a lot of exchanging messages, 
then it is not recommended. Even though UDP slightly performs better than TCP, it is not recommended for accurately 
demand application. It is better for live conference, multimedia, discovery services etc. 
TCP, on the other hand, is good if we deal with a lot of exchanging messages.

*/
public class MessageServer {
  public static void main(String[] args){
    try{
      //Declare message object
      MessageImplementation msgObject =
              new MessageImplementation();
 
      //Create and get reference from registry
      Registry registry = LocateRegistry.createRegistry(1097);
 
      //Register message object
      registry.rebind("Message", msgObject);
 
      System.out.println("Server starts....");
    }catch(RemoteException re){
      re.printStackTrace();
    }
  }
}