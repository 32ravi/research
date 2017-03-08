package Algorithms.Sort;

import java.util.Arrays;
/*
 * Big O(n^2)
 */

public class ArrayInsertionSort {

	public static void main(String[] args) {
		int[] a = {10,20,7,6,9,41,2,12,53};

		int[] b = {2,20,7,6,9,41,3,12};

		//int[] c = {98,20,7,6,9,41,3,2};

		int[] c = {8,3,5,7,9};

		insertionSort(a);
	}


	static void insertionSort(int[] ar)
	{
		System.out.println("Before..." + Arrays.toString(ar));
		for (int i=1; i < ar.length; i++)
		{
			int index = ar[i]; int j = i;
			while (j > 0 && ar[j-1] > index)
			{
				ar[j] = ar[j-1];
				j--;
			}
			ar[j] = index;
			
			System.out.println("after i=" +i + Arrays.toString(ar));
		} 
		
	 System.out.println("After..." + Arrays.toString(ar));	
	}
}
