package networking;

import java.io.*;    
import java.net.*;

/*
 * The Java HttpURLConnection class is http specific URLConnection. It works for HTTP protocol only.
By the help of HttpURLConnection class, 
you can information of any HTTP URL such as header information, status code, response code etc.
 */

public class HttpURLConnectionDemo{    
	public static void main(String[] args){    
		try{    
			URL url=new URL("http://www.javatpoint.com/java-tutorial");    
			HttpURLConnection huc=(HttpURLConnection)url.openConnection();  
			for(int i=1;i<=8;i++){  
				System.out.println(huc.getHeaderFieldKey(i)+" = "+huc.getHeaderField(i));  
			}  
			huc.disconnect();   
		}catch(Exception e){System.out.println(e);}    
	}    
}    