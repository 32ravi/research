package ds;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * Learn 
 * Stream, forEach, enhanced for loop
 *  NOTE : Predicate functional interface used in filter
 */

public class streamExample {

	List<String> mList = new LinkedList<>();  //  NOTE diamond operator

	public static void main(String[] args) {


		streamExample eg = new streamExample();
		eg.mList.add("ABC");
		eg.mList.add("BC");
		eg.mList.add("ADC");
		eg.mList.add("CBC");

		//NOTE Approach 1 STREAM
		long count = eg.mList.stream()
				.filter(a -> a.startsWith("A"))  // RSN NOTE : Predicate functional interface
				.count();

		System.out.println(" Stream Count : " + count) ;


		//Approach 2
		//long forEachCount=0;
		//eg.mList.forEach(a -> { if(a.startsWith("A")) ::forCount++;}    );


		//NOTE Approach 3
		long forCount=0;
		Iterator<String> itr = eg.mList.iterator();
		for(;itr.hasNext();){
			if(itr.next().startsWith("A")){
				forCount++;
			}
		}
		System.out.print("forCount :" + forCount);
		
		
	}
   	
}
