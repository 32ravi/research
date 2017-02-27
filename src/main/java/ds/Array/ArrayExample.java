package ds.Array;

import java.util.Arrays;

/*
 * Learn 
 * Arrays, how to declare, intialize and instantiate.
 * 
 http://javaconceptoftheday.com/array-of-objects-in-java/
 */

public class ArrayExample {
	
	public static void main(String[] args) {
		
		// RSN NOTE -- Step 1 - "array Delclaration"  Both are valid, first one preffered; 
		
		int[] intArrayA; // preferred style
		int arr[];
		
		Long longArrayB[]; // Java inherited from CPP style
		
		// RSN NOTE -- Step 2- Array Instantiation
		intArrayA = new int[10]; arr=new int[8];
		
		longArrayB = new Long[20];
		
		// RSN NOTE -- Step 3- Array Initialization
		
		intArrayA[2] = 23;
		
		longArrayB[2]  = new Long(200000);
		
		// RSN NOTE -- Declaration, instantiation and Initialization all in ONE STEP
		int[] arrayA = {1, 2, 3, 4};
		int[] arrayB = new int[] {1,2,3,4,}; //Both these steps are Valid
			
		Long[] arrayL = new Long[]{new Long(2), new Long(300), new Long(444)};
		
		System.out.println("long array :" + arrayL[2]);
		
		// RSN NOTE --Method 1; array copy  using copyOf -- NOTE Arrays Class it has tons of static methods for array manipulation
		int[] arrayC = Arrays.copyOf(arrayA, arrayA.length); // This is copy by value not by reference
		
		// RSN NOTE --Method 2; copy using System.arraycopy
		int[] arrayCC = new int[arrayA.length];
		System.arraycopy(arrayA, 0, arrayCC, 0, arrayA.length); //System.arraycopy(src, srcPos, dest, destPos, length);
		
		// RSN NOTE --Method 3; Copying using clone method; NOTE below clone method is inherited from object class
		int[] arrayD = arrayA.clone();
		System.out.println("arraD[2] = " + arrayD[2]);
		
		
	}

}
