package IO;

import java.io.*;

//In this example, we are reading and printing the data until the user prints stop.


public class BufferedReaderExample{    
	public static void main(String args[])throws Exception{             
		InputStreamReader r=new InputStreamReader(System.in);    
		BufferedReader br=new BufferedReader(r);           
		String name="";    
		while(!name.equals("stop")){    
			System.out.println("Enter data: ");    
			name=br.readLine();    
			System.out.println("data is: "+name);    
		}              
		br.close();    
		r.close();    
	}    
}    