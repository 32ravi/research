package Algorithms.Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/sorting.html
 * 
 * The algorithm works by comparing each item in the list with the item next to it, and swapping them if required. 
 * In other words, the largest element has bubbled to the top of the array. 
 * The algorithm repeats this process until it makes a pass all the way through the list without swapping any items.
 *Time complexity big O(n^2)
 * https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html
 * 
 */
public class ArrayBubbleSort {

	public static void main(String[] args) {
		int[] a = {10,20,7,6,9,41,2,12,53};
		
		int[] b = {2,20,7,6,9,41,3,12};
		
		//int[] c = {98,20,7,6,9,41,3,2};
		
		int[] c = {8,3,5,7,9};
		bubbleSort(a);
		bubbleSort(b);
		bubbleSort(c);
	}
	
	public static void bubbleSort(int[] a){
		System.out.println("Before ....:" + Arrays.toString(a));
		
		int l=a.length, bigO=0;
		boolean swaped = true;

		//by usin swaped check in the for loop soring can be accomplished before n^2 iteration.
//		for(int i=0; i<l & swaped ;i++ ){  //i from this for loop is not used below, it is only to count total iterations
		for(int i=0; i<l ;i++ ){
			swaped = false;
			for(int k=1;k<l ; k++){
				
				if(a[k] < a[k-1]){
				     int temp = a[k-1];
				     a[k-1] = a[k];
				     a[k] = temp;
				     swaped = true;
				}
				bigO++;
			}
			 
		}
		
		System.out.println("After "+ bigO +" itr:" + Arrays.toString(a));
	}
}
