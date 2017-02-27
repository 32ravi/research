package ds.Array;

import java.util.Arrays;

/*
 * 
 * Given an array of integers, you have to find all pairs of elements in this array such that whose sum must
 *  be equal to a given number.
For example, if {4, 5, 7, 11, 9, 13, 8, 12} is an array and 20 is the given number,
 then you have to find all pairs of elements in this array whose sum must be 20.

You can use double for loop to find this but it will give you Big O(n^2), this is pretty bad

Another approach is to sort the array, and then start for two ends and calculate.
This will have Big O(nlog(n))
 */
public class PairOfElementsInArray {
	
	public static void findThePair(int[] a, int inputNumber){
		//sort the array first
		Arrays.sort(a); //NOTE Big O(n)
		
		System.out.println("sorted array : " + Arrays.toString(a) );
		int i=0; //start index
		int j= a.length -1; //last index
		
		while( i < j){ //NOTE Big O(log(n)  so total Big O(nLog(n))
			
			int sum= a[i] + a[j];
			if (sum == inputNumber){
				System.out.println( a[i] + "+" + a[j]  + " = " + sum);
				 
				i++;
				j--;
			}
			else if (sum < inputNumber) { // We need to pick a bigger number so increment i
				i++;
			}
			else if ( sum > inputNumber){ // we need to pick a smaller number
				j--;
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		PairOfElementsInArray.findThePair(new int [] {4,5,11,7,9,13,8,12 },20);
		
		PairOfElementsInArray.findThePair(new int [] {5,101,7,9,13,8,12 },17);
		
		findThePair(new int[] {12, 13, 10, 15, 8, 40, -15}, 25);
		
		findThePair(new int[] {12, 23, 10, 41, 15, 38, 27}, 50);
	}

}
