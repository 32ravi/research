package ds.Array;

/*
 http://javaconceptoftheday.com/interesting-observations-about-arrays-in-java/
 */
public class ArrayObservations {
	public static void main(String[] args) {
		
	   // int[] i = new int[-5];   //No Compile Time Error
        //You will get java.lang.NegativeArraySizeException at run time
	    
	
	    /*
		 * 3) Declaration and instantiating of an array strictly must be of same type.
No auto-widening, auto-boxing and auto-unboxing is allowed. But only auto-upcasting is allowed.
		 */
	   // Integer[] I = new int[5];   //Compile Time Error : Auto-Boxing not allowed
	    
        //int[] i = new Integer[10];   //Compile Time Error : Auto-UnBoxing not allowed
 
        //long[] l = new byte[10];    //Compile Time Error : Auto-widening not allowed
 
        Object[] o1 = new String[10];    //No Compile Time Error : Auto-Upcasting is allowed, String[] is upcasted to Object[]

        
        /*
) The type of elements of an array must be compatible with type of the array object. 
If you try to store non-compatible element in an array object, you will get ArrayStoreException at run time.
         */
        
        Object[] o = new String[10];    //No Compile Time Error : String[] is auto-upcasted to Object[]
        
        //i.e array object of strings can be referred by array reference variable of Object type
        o[2] = "java";
 
        o[5] = 20;   //No Compile time error, 
        //but you will get java.lang.ArrayStoreException at run time.
      
        
        /*
         * While creating multi dimensional arrays, you can not specify an array dimension after an empty dimension.
         */
       // int[][][] threeDArray = new int[10][][10];    //Compile Time Error
        
        //int[][][] threeDArray1 = new int[][10][];     //Compile Time Error
 
        int[][][] threeDArray2 = new int[10][][];     //OK
        
        
      //Creating anonymous array
        System.out.println(new int[]{1, 2, 3}.length);    //Output : 3
        System.out.println(new int[]{47, 21, 58, 98}[1]);   //Output : 21
	    
	}

}
