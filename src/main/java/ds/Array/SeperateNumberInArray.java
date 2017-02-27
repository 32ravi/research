package ds.Array;

import java.util.Arrays;

/*
 * Given an integer array, you have to separate all zero elements from non-zero elements.
 *  You have to move zeros either to end of the array or bring them to beginning of the array. For example, if {14, 0, 5, 2, 0, 3, 0} is the given array, then moving zeros to end of the array 
 * will result {14, 5, 2, 3, 0, 0, 0} and bringing zeros to front will result {0, 0, 0, 14, 5, 2, 3}. 
 */
public class SeperateNumberInArray {
	
	//I have two index, one that tracks empty index and another that tracks current index
	static void moveNumberAtEnd(int[] a, int numberToMove){
		System.out.println("Input " + Arrays.toString(a));
		int currentIndex=0, emptyIndex=0;
		
		for(int i=0; i< a.length; i++){
			int currentValue = a[i];
			
			if(currentValue == numberToMove){
				currentIndex++;
			}
			else if (currentIndex == emptyIndex){ 
				emptyIndex++;
				currentIndex++;
			}
			else if ( emptyIndex < currentIndex){
				a[emptyIndex] = currentValue;
				emptyIndex++;
				currentIndex++;
			}
		}
		
		//Now fill in empty index
		for(int i=emptyIndex; i< a.length; i++){
			a[i] = numberToMove;
		}
		
		System.out.println("move :" + Arrays.toString(a));
	}
	
	static void moveNumberAtFront(int[]a, int numberToMove){
		System.out.println("Input Front " + Arrays.toString(a));
		
		int maxIndex=a.length - 1;
		int currentIndex=maxIndex, emptyIndex = maxIndex;
		
		for (int i = maxIndex; i>=0; i--)
		{
			int currentValue = a[i];
			if(currentValue == numberToMove)
			{
				currentIndex--;
			}
			else if(currentIndex == emptyIndex){
				currentIndex--;
				emptyIndex--;
			}
			else if (currentIndex < emptyIndex){
				a[emptyIndex] = currentValue;
				emptyIndex--;
				currentIndex--;
			}
		}
		
		for(int i = emptyIndex; i >=0; i--){
			a[i] = numberToMove;
		}
		
		System.out.println("move Front:" + Arrays.toString(a));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		moveNumberAtEnd(new int[] {12,0,11,0,0,12,14,0,15},0);
		
		moveNumberAtEnd(new int[] {12,0,11,0,0,12,14,0,15},12);
		
        moveNumberAtFront(new int[] {12,0,11,0,0,12,14,0,15},0);
		
		moveNumberAtFront(new int[] {12,0,11,0,0,12,14,0,15},12);
	}

}
