package ds.Set;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * http://www.codejava.net/java-core/collections/java-set-collection-tutorial-and-examples
 */
public class SetDemo {

	public static void main(String[] args) {
		boolean result;
		
		Set<Integer> numbers = new HashSet<>(); 
		//====NOTE=====>>> RSN IMP HashSet is basically HashMap with Keys and dummy values.
		
		numbers.add(3);
		numbers.add(1);
		result = numbers.add(2);
		
		System.out.println("unique add result : " + result);
		System.out.println(numbers.toString());
		
		result = numbers.add(2);//====NOTE=====>>> PROPERTY OF SET; keeps UNIQUE elements, NO duplicates
		System.out.println("duplicate add result = " +result);
		
		System.out.println(numbers.toString());
		
		//====NOTE=====>>> synchronized set
		//HashSet is not synchronized, to obatins synchronized set
		
		Set<String> synchSet = Collections.synchronizedSet(new HashSet<String>()); // RSN NOTE IMP Synchronized Set
		synchSet.add("Mumbai");
		
		//==================================================
		//We can create a Set from an existing collection. 
		//====NOTE=====>>> This is a trick to remove duplicate elements in non-Set collection
		
		List<Integer> listNumbers = Arrays.asList(3, 9, 1, 4, 7, 2, 5, 3, 8, 9, 1, 3, 8, 6);
		System.out.println(listNumbers);
		Set<Integer> uniqueNumbers = new HashSet<>(listNumbers);
		System.out.println("unique numbers =" + uniqueNumbers);
		
		//==================================================
		//As with Java 8, we can use stream with filter and collection functions to return a Set from a collection. 
		//The following code collects only odd numbers to a Set from the listNumbers above:
		//====NOTE=====>>> STREAM Example.....FIND UNIQUE ODD NUMBERS from a given list
		
			Set<Integer> uniqueOddNumbers = listNumbers.stream()
			    .filter(number -> number % 2 != 0).collect(Collectors.toSet()); //NOTE --IMP LOGIC; NOTE Collectors
			 
			System.out.println(uniqueOddNumbers);
			
		//==================================================
		 //Basic add operation to set
			
			Set<String> names = new HashSet<>();
			names.add("Tom");
			names.add("Mary");
			 
			if (names.add("Peter")) {
			    System.out.println("Peter is added to the set");
			}
			 
			if (!names.add("Tom")) {
			    System.out.println("Tom is already added to the set");
			}
			
			
		//==================================================
		//Note that the Set interface does not provide any API for retrieving a specific element due to its nature of unordered. 
		//Except the TreeSet implementation allows retrieving the first and the last elements.
	     System.out.println(" SET READ Operation ------");
			//SET READ
			
		//Approach 1 - Iterator
		Iterator itr = names.iterator();	
		while(itr.hasNext()){
			System.out.print(itr.next());
		}
		
		//Approach 2 - Enahanced for
		System.out.println("\nRead Set via enhanced for loop");
		for(String name : names){
			System.out.print(name);
		}
		
		//Approach 3 - forEach
		//====NOTE=====>>>*********forEach Lambda expression
		names.forEach(System.out::print);
		
		
		

	}

}
