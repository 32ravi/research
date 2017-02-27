package IO;

import java.io.FileInputStream;  
public class DataStreamExample {  
	public static void main(String args[]){    
		try{    
			FileInputStream fin=new FileInputStream("C:\\Ravi\\workspace\\text\\testout.txt");    
			int i=0;    
			while((i=fin.read())!=-1){    
				//System.out.print((char)i); //A---This is my data
				System.out.print(i + " ");  //65 45 45 45 84 104 105 115 32 105 115 32 109 121 32 100 97 116 97   
			}
			fin.close();
		}catch(Exception e){System.out.println(e);}    
	}    
}  
