package Algorithms.recursion;

/*
 * Recursive code begins with a base case if-statement which checks for one or more cases that are so simple, that the answer can be returned immediately.
 *  That is followed by a recursive case which calls the same method with slightly smaller inputs, and then fixes up what it returns. 
 *  "Smaller" inputs means at least one step towards the base case.

The base case returns a value without making any subsequent recursive calls. It does this for one or more special input values for which the function can be evaluated without recursion. For factorial(), the base case is n = 1.
The reduction step is the central part of a recursive function. It relates the value of the function at one (or more) input values to the value of the function at one (or more) other input values. Furthermore, the sequence of input values values must converge to the base case. For factorial(), the value of n decreases by 1 for each call, so the sequence of input values converges to the base case.

 */
public class RecursionFactorial {

	public static void main(String[] args) {


		//Count A in the string
		String pattern = "XBYACADDA";
		System.out.println(" patter : " + pattern + " " + countAInString(pattern));

		//Find factorial
		int fact = 5;
		System.out.println("Factorial : " + fact + "= " + factorial(fact));
		
		/*
		 * We have a number of bunnies and each bunny has two big floppy ears.
		 *  We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).
		 */
		System.out.println("bunny ears" + bunnyEars(12));
	}

	private static  int countAInString(String str) {
		if(str.length() == 0)
			return 0;

		int count=0;
		if(str.substring(0, 1).equals("A")){
			count =1;
		}

		return count + countAInString(str.substring(1));

	}

	private static int factorial(int n){
		/* Real code is only 4 liners below
		if(n <=1)
			return 1;
		else
			return n*factorial(n-1);
		*/
		
		
		System.out.println("in with n="+n);
		if(n <=1){
			System.out.println("returning n=" + n);   
			return n;
		}
		else{
			int valueFromChild = factorial(n-1);
			System.out.println("                      value being fed :" + valueFromChild);
			int ret = n*valueFromChild;
			System.out.println("               n=" + n + "returning" + ret );
			return ret;
		}
	}
	
	private static int  bunnyEars(int bunnies) {
		if(bunnies == 0)
			return 0;
		else
			return 2+ bunnyEars(bunnies -1);
	}


}

