package Algorithms.Sort;

import java.util.Arrays;


public class ArraySelectionSort {

	public static void main(String[] args) {
		
		int[] a = {10,20,7,6,9,41,2,12};
		
		sort(a);
		
	}
	
	public static void sort(int[] a){
		
		System.out.println("Before ...     " + Arrays.toString(a));
		int bigO=0;
		for(int i=0; i< a.length; i++){
			int c = a[i];
			
			int k,tempV, tempK=i;
			for(k=i,tempV=a[i]; k< a.length; k++){
			
			    if(a[k]<tempV){
			    	//a[temp] = a[k];
			    	tempV=a[k];
			    	tempK=k;
			    }
			    bigO++;
			}
			
			a[tempK] = a[i];
			a[i]=tempV;
			
			System.out.println("after round :"+ i + " " + Arrays.toString(a));
			
		}
		System.out.println("After bigO(n^2):"+ bigO +" rounds " + Arrays.toString(a));
		
	}
	
}
