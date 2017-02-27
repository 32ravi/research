package networking;

import java.net.*;
import java.io.*;

/*
 * Supporting Multiple Clients

To keep the KnockKnockServer example simple, we designed it to listen for and handle a single connection request. However, multiple client requests can come into the same port and, consequently, into the same ServerSocket. Client connection requests are queued at the port, so the server must accept the connections sequentially. However, the server can service them simultaneously through the use of threads—one thread per each client connection.

The basic flow of logic in such a server is this:

while (true) {
    accept a connection;
    create a thread to deal with the client;
}
The thread reads from and writes to the client connection as necessary.

 */
public class KKMultiServer {
	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			System.err.println("Usage: java KKMultiServer <port number>");
			System.exit(1);
		}

		int portNumber = Integer.parseInt(args[0]);
		boolean listening = true;

		try (ServerSocket serverSocket = new ServerSocket(portNumber)) { 
			while (listening) {
				new KKMultiServerThread(serverSocket.accept()).start();
			}
		} catch (IOException e) {
			System.err.println("Could not listen on port " + portNumber);
			System.exit(-1);
		}
	}
}