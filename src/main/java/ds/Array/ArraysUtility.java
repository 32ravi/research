package ds.Array;

import java.util.Arrays;

/*
 * Learn
 * Arrays.toString()
 * Arrays.sort
 * Arrays.binarySearch
 * copyOf
 * equal
 * deepEqual
 * deepToString
 * 
 */

public class ArraysUtility {
	
	public static void main(String[] args)
    {
        //An array of byte
        byte[] b = {10, 20, 30};          
 
        System.out.println(Arrays.toString(b));  //RSN NOTE Arrays.toString      //Output : [10, 20, 30]
 
        //An array of short
        short[] s = {40, 50, 60, 70, 8, 7, 90};        
 
        System.out.println(Arrays.toString(s));       //Output : [40, 50, 60, 70]
        
        Arrays.sort(s); //RSN NOTE sort
        System.out.println("Sorted Array..." + Arrays.toString(s));
 
        //An array of String
        String[] str = {"java", "concepts", "Arrays", "methods"};
 
        System.out.println(Arrays.toString(str));     //Output : [java, concepts, Arrays, methods]
 
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
       
        
        //An array of int
        int[] i = {12, 21, 42, 68,6,7,90};   
 
        System.out.println(Arrays.toString(i));      //Output : [12, 21, 42, 68]
        
        System.out.println("binary search " + Arrays.binarySearch(i, 68)); 
        // output=3; RSN NOTE - array is not sorted so results are not correct
        
        Arrays.sort(i);
        System.out.println(Arrays.toString(i));
        System.out.println("binary search " + Arrays.binarySearch(i, 68)); //output 5 NOTE after sorting correct value of binary search
        
        //An array of double
        double[] dd = {12.5, 14.8, 45.9, 23.5};
        //RSN NOTE Arrays.fill
        Arrays.fill(dd, 53.6);    //Assigns 53.6 to each element of the array
        System.out.println(Arrays.toString(dd));   //Output : [53.6, 53.6, 53.6, 53.6]
 
        //RSN Copying array dd into array d1
        double[] d1 = Arrays.copyOf(dd, 4);
        System.out.println("Copied array..." + Arrays.toString(d1));    //Output : [12.5, 45.8, 56.2, 47.9]
 
        //An array of long
        long[] l = {100, 110, 120, 130, 140, 150};
 
        System.out.println(Arrays.toString(l));      //Output : [100, 110, 120, 130, 140, 150]
 
        //An array of double
        double[] d = {12.5, 14.9, 87.4, 55.8};
 
        System.out.println(Arrays.toString(d));      //Output : [12.5, 14.9, 87.4, 55.8]
 
        //An array of char
        char[] c = {'A', 'B', 'C', 'D', 'E'};
 
        System.out.println(Arrays.toString(c));     //Output : [A, B, C, D, E]
 
        //An array of boolean
        boolean[] bln = {true, false, false, true};
 
        System.out.println(Arrays.toString(bln));     //Output : [true, false, false, true]
        
        // RSN NOTE -- EQUALITY OF TWO ARRAY HOW TO CHECK
        String[] s1 = {"java", "swings", "j2ee", "struts", "jsp", "hibernate"};
        String[] s2 = {"java", "struts", "j2ee", "hibernate", "swings", "jsp"};
        System.out.println("before sort, array equal " + Arrays.equals(s1, s2));       //Output : false
 
        Arrays.sort(s1);
        Arrays.sort(s2);
        System.out.println("after sort, array equal " + Arrays.equals(s1, s2));       //Output : true
        
        /*
         * If you are checking multidimensional arrays for equality, then use deepEquals() method of Arrays class 
         * instead of equals() method. Because, deepEquals() performs deep comparison of both the arrays.
         * RSN NOTE - deepEqual
         */
        String[][] ss1 = { {"java", "swings", "j2ee" }, { "struts", "jsp", "hibernate"} };
        String[][] ss2 = { {"java", "swings", "j2ee" }, { "struts", "jsp", "hibernate"} };
 
        System.out.println("deepEqual " + Arrays.deepEquals(ss1, ss2));     //Output : true
        //Calling equals() method on same arrays will return false
         
        System.out.println("deepEqual " + Arrays.equals(ss1, ss2));        //Output : false
        //That's why use deepEquals() method to compare multidimensional arrays
        // RSN NOTE -- deepToString will print multidimensional array
        System.out.println("deepToString output : " + Arrays.deepToString(ss1));
 
    }

}
