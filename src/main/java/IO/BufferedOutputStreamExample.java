package IO;

import java.io.*; 
/*java BufferedOutputStream class is used for buffering an output stream.
 *  It internally uses buffer to store data. It adds more efficiency than to write data directly 
 *  into a stream. So, it makes the performance fast.
For adding the buffer in an OutputStream, use the BufferedOutputStream class.
 Let's see the syntax for adding the buffer in an OutputStream:
*/
public class BufferedOutputStreamExample{    
	public static void main(String args[])throws Exception{    
		FileOutputStream fout=new FileOutputStream("C:\\Ravi\\workspace\\text\\testout.txt");    
		BufferedOutputStream bout=new BufferedOutputStream(fout);    
		String s="Welcome to javaTpoint.";    
		byte b[]=s.getBytes();    
		bout.write(b);    
		bout.flush();    
		bout.close();    
		fout.close();    
		System.out.println("success");    
	}    
}  