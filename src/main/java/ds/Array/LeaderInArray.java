package ds.Array;

import java.util.Arrays;

/*
Given an integer array, you have to find all the leader elements in this array. 
An element is said to be leader if all the elements on it’s right side are smaller than it.
 Rightmost element is always a leader. For example, if {14, 9, 11, 7, 8, 5, 3} is the given array then {14, 11, 8, 5, 3} are the leaders in this array.
 
 Big O(n)
 */

public class LeaderInArray {
	
	static void findLeaders(int[]a){
		System.out.println("Given array " + Arrays.toString(a));
		//int lastLeader = 0;// notice that zero won't work for negative number
		int lastLeader = a[a.length -1];
		int currentValue;
		
		for(int i=a.length-1; i>= 0; i--){
			currentValue = a[i];
			
			if(currentValue >= lastLeader){
				System.out.println(currentValue);
				lastLeader = currentValue;
			}
			
		}
	}
	
	public static void main(String[] args) {
		
        findLeaders(new int [] {5,101,7,9,13,8,12 });
		
        findLeaders(new int[] {12, 13, 10, 15, 8, 40, -15});
		
        findLeaders(new int[] {12, 23, 10, 41, 15, 38, 27});
	}

}
