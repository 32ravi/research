package ds.Queue;

import java.util.ArrayDeque;

//DoubleEndedQueue Dek DeQue
public class ArrayDequeDemo {

	public static void main(String[] args) {

		/*The following code snippet adds an element to 
		the head and an element to the tail of a double ended queue (notice the type of the interface is used):
		 */
		
		ArrayDeque<String> aDeq = new ArrayDeque<>();
		
		aDeq.add("kat");
		aDeq.add("bob");
		
		aDeq.addFirst("TomFirst"); //addFirst
		aDeq.addLast("JilLast");  //addLast
		
		System.out.println("Q after additions " + aDeq.toString()); //[TomFirst, kat, bob, JilLast] //====NOTE=====>>> notice order of elements
		
		aDeq.pollFirst();
		
		System.out.println("after pollFirst " + aDeq.toString());
		
		aDeq.pollLast();
		
		System.out.println("after pollLast " + aDeq.toString());
		
	}

}
