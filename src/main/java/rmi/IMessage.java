package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author http://lycog.com
 * Step 1: Interface
 */
public interface IMessage extends Remote{
  void captureMessage(byte[] message) throws RemoteException;
}