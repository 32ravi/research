package Algorithms.recursion;

import javax.print.attribute.standard.Finishings;

/*
 * Fibonacci sequence
 * 0,1,1,2,3,5,8......(n-2  + n -1)
 */
public class Fibonacci {
	public static void main(String[] args) {
		
		System.out.println("n = " + fibonacci(6));
		
		System.out.println("n = " + fibonacci(7));
		
		System.out.println("n = " + fibonacci(8));
		
		System.out.println("Using For loop...");
        System.out.println("n = " + fibonacciFor(6));
        System.out.println("n = " + fibonacciFor(7));
		System.out.println("n = " + fibonacciFor(8));
	}
	
	private static int fibonacci(int n){
		if(n <=0 ){
			return 0;
		}
		
		if(n == 1){
			return 1;
		}
		
		return fibonacci(n-2) + fibonacci(n-1);
	}
	
	// Fibnocci without recursion
	private static int fibonacciFor(int n){
		
		int current = 0;
		//previous2, previous1,n
		int previous1 = 1;
		int previous2=0;
		
		for(int i=1; i< n; i++){
			current= previous1+previous2;
			previous2 = previous1;
			previous1=current;
		}
		
		return current;
	}

}
