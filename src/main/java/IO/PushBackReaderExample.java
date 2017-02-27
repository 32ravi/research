package IO;

import java.io.*;

/*The Java PushbackReader class (java.io.PushbackReader) is intended to be used when you parse data from a 
 * Reader. Sometimes you need to read ahead a few characters to see what is coming, before you can determine
 *  how to interpret the current character. The PushbackReader allows you to do that. 
 *  Well, actually it allows you to push back the read characters into the Reader. 
 *  These characters will then be read again the next time you call read().

The Java PushbackReader works much like the PushbackInputStream except that the PushbackReader works on 
characters, whereas the PushbackInputStream works on bytes.
*/
public class PushBackReaderExample {

	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("C:\\Ravi\\workspace\\text\\testout.txt");

		try(PushbackReader pushbackReader =
		    new PushbackReader(reader)){

		    int data = pushbackReader.read();
		    int count=0;
		    while(data != -1 && count < 200) {
		        System.out.print((char) data);
		        data = pushbackReader.read();
		       // pushbackReader.unread(data);  // Uncomenting this line will print Weeeeeeeeeeeeeeeeeee
		        count++;
		    }
		}
	}

}
