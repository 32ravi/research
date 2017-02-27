package networking;

import java.io.*;  
import java.net.*; 
/*
 * The Java URLConnection class represents a communication link between the URL and the application.
 *  This class can be used to read and write data to the specified resource referred by the URL.
 */
public class URLConnectionExample {  
	public static void main(String[] args){  
		try{  
			URL url=new URL("http://www.javatpoint.com/java-tutorial");  
			URLConnection urlcon=url.openConnection();  
			InputStream stream=urlcon.getInputStream();  
			int i,j=0;  
			while((i=stream.read())!=-1){  
				System.out.print((char)i);
				j++;
				//System.out.print(i);  
			}
			System.out.println(" j=" + j);
		}catch(Exception e){System.out.println(e);}  
	}  
}  
