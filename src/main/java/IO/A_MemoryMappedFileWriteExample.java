package IO;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/*
 http://howtodoinjava.com/java-7/nio/java-nio-2-0-memory-mapped-files-mappedbytebuffer-tutorial/
 */
 
public class A_MemoryMappedFileWriteExample {
    private static String bigExcelFile = "C:\\Ravi\\workspace\\text\\mmap.dat";
 
    public static void main(String[] args) throws Exception {
        // Create file object
        File file = new File(bigExcelFile);
         
        //Delete the file; we will create a new file
        file.delete();
 
        // Get file channel in readonly mode
        FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
 
        // Get direct byte buffer access using channel.map() operation
        MappedByteBuffer buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 4096 * 8 );
 
        //Write the content using put methods
        buffer.put("howtodoinjava.com".getBytes());
        buffer.put("----howtodoinjava.com22".getBytes());
        
    }
}
