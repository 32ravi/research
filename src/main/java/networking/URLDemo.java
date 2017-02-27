package networking;

//URLDemo.java  
import java.io.*;  
import java.net.*;  

/*
 * The Java URL class represents an URL. 
 * URL is an acronym for Uniform Resource Locator. It points to a resource on the World Wide Web.
 */
public class URLDemo{  
	public static void main(String[] args){  
		try{  
			URL url=new URL("http://www.javatpoint.com/java-tutorial");  

			System.out.println("Protocol: "+url.getProtocol());  
			System.out.println("Host Name: "+url.getHost());  
			System.out.println("Port Number: "+url.getPort());  
			System.out.println("File Name: "+url.getFile());  

		}catch(Exception e){System.out.println(e);}  
	}  
}  