package performance;

/*
 * Learn - 
 1. Calculate size of any object in java
 2.Use of Runtime to check free memory of app
 3. Use of Runtime to invoke fullGC
 * 
 http://www.javaworld.com/article/2077496/testing-debugging/java-tip-130--do-you-know-your-data-size-.html
 * 
 * Sizeof's key methods are runGC() and usedMemory(). I use a runGC() wrapper method to call _runGC() several times because it appears to make the method more aggressive. (I am not sure why, but it's possible creating and destroying a method call-stack frame causes a change in the reachability root set and prompts the garbage collector to work harder. Moreover, consuming a large fraction of the heap space to create enough work for the garbage collector to kick in also helps. In general, it is hard to ensure everything is collected. The exact details depend on the JVM and garbage collection algorithm.)

Note carefully the places where I invoke runGC(). You can edit the code between the heap1 and heap2 declarations to instantiate anything of interest.

Also note how Sizeof prints the object size: the transitive closure of data required by all count class instances, divided by count. For most classes, the result will be memory consumed by a single class instance, including all of its owned fields. That memory footprint value differs from data provided by many commercial profilers that report shallow memory footprints (for example, if an object has an int[] field, its memory consumption will appear separately).
 */

public class Sizeof
{
    public static void main (String [] args) throws Exception
    {
        // Warm up all classes/methods we will use
        runGC ();
        usedMemory ();
        // Array to keep strong references to allocated objects
        final int count = 100000;
        Object [] objects = new Object [count];
        
        long heap1 = 0;
        // Allocate count+1 objects, discard the first one
        for (int i = -1; i < count; ++ i)
        {
            Object object = null;
            
            // Instantiate your data here and assign it to object
            
            //object = new Object ();
            //object = new Integer(i);
            //object = new Long (1);
        
            
            // RSN NOTE -- notice difference of size between String and char example below
            //object = new String ("A");//24 bytes
            //object = new String ("ABCDEFGHIJKLMONONONOONNOJLKJFLSJFLKJDSFLKJDSLFJJLKJLGDJLKJF"); // 24 bytes; 
                               //NOTE because string literal is reused, length of string does not matter 
            //object = "ABCDEFGHIJKLMONONONOONNOJLKJFLSJFLKJDSFLKJDSLFJJLKJLGDJLKJF"; //0 bytes; NOTE String literals are used from string constant pool
            
            
            object = new char[]{'a'}; //24 bytes
            object = new char[]{'a','B','a','a','a','a','a'}; //32 bytes
            //object = new char[]{'a','b','a','b','a','b','a','b','a','b'}; // 40 bytes; NOTE because char[] don't use string constant pool bytes used are more for bigger strings.
           
            //object = new byte [128][1]
            
            if (i >= 0)
                objects [i] = object;
            else
            {
                object = null; // Discard the warm up object
                runGC ();
                heap1 = usedMemory (); // Take a before heap snapshot
            }
        }
        runGC ();
        long heap2 = usedMemory (); // Take an after heap snapshot:
        
        final int size = Math.round (((float)(heap2 - heap1))/count);
        System.out.println ("'before' heap: " + heap1 +
                            ", 'after' heap: " + heap2);
        System.out.println ("heap delta: " + (heap2 - heap1) +
            ", {" + objects [0].getClass () + "} size = " + size + " bytes");
        for (int i = 0; i < count; ++ i) objects [i] = null;
        objects = null;
    }
    private static void runGC () throws Exception
    {
        // It helps to call Runtime.gc()
        // using several method calls:
        for (int r = 0; r < 4; ++ r) _runGC ();
    }
    private static void _runGC () throws Exception
    {
        long usedMem1 = usedMemory (), usedMem2 = Long.MAX_VALUE;
        for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++ i)
        {
            s_runtime.runFinalization ();
            s_runtime.gc ();
            Thread.currentThread ().yield ();
            
            usedMem2 = usedMem1;
            usedMem1 = usedMemory ();
        }
    }
    public static long usedMemory ()
    {
        return s_runtime.totalMemory () - s_runtime.freeMemory ();
    }
    
    public static final Runtime s_runtime = Runtime.getRuntime ();
} // End of class
