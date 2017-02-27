package IO;

import java.io.StringReader;


/*Java StringReader class is a character stream with string as a source.
 *  It takes an input string and changes it into character stream. It inherits Reader class.
 *  RSN - seems like just string to char functionality

In StringReader class, system resources like network sockets and files are not used, therefore closing the StringReader is not necessary.*/
public class StringReaderExample {  
    public static void main(String[] args) throws Exception {  
        String srg = "Hello Java!! \nWelcome to Javatpoint.";  
        StringReader reader = new StringReader(srg);  
        int k=0;  
            while((k=reader.read())!=-1){  
                System.out.print((char)k);  
            }  
        }  
}  