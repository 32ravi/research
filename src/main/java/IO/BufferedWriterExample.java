package IO;

 
import java.io.*;  
public class BufferedWriterExample {  
public static void main(String[] args) throws Exception {     
    FileWriter writer = new FileWriter("C:\\Ravi\\workspace\\text\\filewriter.txt");  
    BufferedWriter buffer = new BufferedWriter(writer);  
    buffer.write("Welcome to javaTpoint.");  
    buffer.close();  
    System.out.println("Success");  
    }  
}  
