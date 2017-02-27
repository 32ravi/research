package IO;

import java.io.FileOutputStream; 

/*Java FileOutputStream is an output stream used for writing data to a file.

If you have to write primitive values into a file, use FileOutputStream class. 
You can write byte-oriented as well as character-oriented data through FileOutputStream class.
 But, for character-oriented data, it is preferred to use FileWriter than FileOutStream.*/
public class FileOutputStreamExample {  
	public static void main(String [] argv){    
		try{    
			FileOutputStream fout=new FileOutputStream("C:\\Ravi\\workspace\\text\\testout.txt");   
			
			String data = "---This is my data 123 ABC";
			
			byte [] byteData = data.getBytes();
			fout.write(65);
			fout.write(byteData);
			
			//fout.write(196);
			//fout.write(140);
			fout.close();    
			System.out.println("success...");    
		}catch(Exception e){System.out.println(e);} 
		//The content of a text file testout.txt is set with the data A.
	}    
} 
