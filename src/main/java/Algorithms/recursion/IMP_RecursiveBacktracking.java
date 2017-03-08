package Algorithms.recursion;

import java.util.Arrays;

/*
 * Given an array of ints, is it possible to choose a group of some of the ints, such that the group sums 
 * to the given target? This is a classic backtracking recursion problem. 
 * Once you understand the recursive backtracking strategy in this problem, 
 * you can use the same pattern for many problems to search a space of choices. 
 * Rather than looking at the whole array, our convention is to consider the part of the array starting at i
 * ndex start and continuing to the end of the array. The caller can specify the whole array simply by passing start as 0.
 *  No loops are needed -- the recursive calls progress down the array.
 *groupSum(0, [2, 4, 8], 10) -- true
  groupSum(0, [2, 4, 8], 14) --true
  groupSum(0, [2, 4, 8], 9) -- false  
 */
public class IMP_RecursiveBacktracking {
	public static void main(String[] args) {
		
		int [] array1 = {10,2,2,5};//15
		
		int [] array2 = {10,2,2,5};//17
		
		int [] array3 = {2,4,8,9}; //
		//System.out.println(Arrays.toString(array1) + " sum " +15 + " " + groupSum(0,array1,15));
		//System.out.println(Arrays.toString(array2) + " sum " +17 + " " + groupSum(0,array2,17));
		System.out.println(Arrays.toString(array3) + " sum " +9 + " " + groupSumDebug(0,array3,6,""));
		System.out.println(Arrays.toString(array3) + " sum " +9 + " " + groupSum(0,array3,6));
		
	}

	public static boolean groupSum(int start, int[] nums, int target) {

		if(start >= nums.length )
			return target == 0;
		if(target == nums[start])
			return true;

		if (  groupSum(start+1, nums, target-nums[start])) 
			return true;
		else
			return groupSum(start+1, nums, target);
	}

	public static boolean groupSumDebug(int start, int[] nums, int target, String prefix) {
		
/*		Total code without debug
 		if(start >= nums.length )
			return target == 0;
		if(target == nums[start])
			return true;
		
		if (  groupSum(start+1, nums, target-nums[start])) 
			return true;
		else
			return groupSum(start+1, nums, target);
*/		
		
		System.out.println(prefix + "start/target " + start + ":" + target);
		
		// Base case: if there are no numbers left, then there is a
		  // solution only if target is 0.
		if(start >= nums.length )
			return target == 0;

		if(target == nums[start])
			return true;

		// Key idea: nums[start] is chosen or it is not.
		  // Deal with nums[start], letting recursion
		  // deal with all the rest of the array.
		  
		  // Recursive call trying the case that nums[start] is chosen --
		  // subtract it from target in the call.
		
		if (  groupSumDebug(start+1, nums, target-nums[start], prefix + "    ")){ 
		    System.out.println(prefix + "returning");
			return true;
		}
		else{
			System.out.print(prefix + "exclusion ");
			boolean r1=  groupSumDebug(start+1, nums, target, prefix + "    ");
			System.out.println(prefix + "returning exclusion");
			return r1;
		}
		 // Recursive call trying the case that nums[start] is not chosen.
	}
}
