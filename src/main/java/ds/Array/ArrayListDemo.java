package ds.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



/*
 * drawbacks of arrays.

Arrays are of fixed length. You can not change the size of the arrays once they are created.
You can not accommodate an extra element in an array after they are created.
Memory is allocated to an array during it’s creation only, much before the actual elements are added to it.
Because of these drawbacks, use of arrays are less preferred. Instead of arrays, you can use ArrayList class
 which addresses all these drawbacks. Here are some advantages of using ArrayList over arrays.
 
 */

public class   ArrayListDemo{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// RSN NOTE -- ArrayList can grow in size, arrays can't
		list.add(1);
		list.add(2);
		System.out.println("Length " + list.size());
		
		// RSN NOTE -- Elements can be inserted or deleted from any locaiton, NOT in array
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("ONE");
		sList.add("TWO");
		sList.add("THREE");
		sList.remove(1);   // ====NOTE=====>>>   compare Arraylist remove with LinkedListDemo remove
		System.out.println(sList.toString());
		
		System.out.println("Contains "+sList.contains("THREE")); //====NOTE=====>>>SUPER IMP; compare contains of arrayList and Linked List
		
		/*
		 * ArrayList class has methods to perform solo modifications ( add(), remove()… ), 
		 * bulk modifications ( addAll(), removeAll(), retainAll()… ), searching( indexOf(), lasIndexOf() ) and iterations( iterator() ).
		 */
		
		// RSN NOTE -- If generics are not used, ARRAY list can hold any data type
		 ArrayList listForAll = new ArrayList();     //ArrayList without generics
	        listForAll.add("ZERO");    //adding string type object
	        listForAll.add(1);        //adding primitive int type
	        listForAll.add(20.24);    //adding primitive double type
	        listForAll.add(new Float(23.56));   //Adding Float wrapper type object
	        listForAll.add(new Long(25));      //Adding Long wrapper type object
	 
	        System.out.println(listForAll);     //Output : [ZERO, 1, 20.24, 23.56, 25]
	        
	        // RSN NOTE -- Array Insertion time
	        arrayInserionTime();
	        
	        listIteratorMovesInBothDirections();
	        
	        reverseElementInList();
	        
	        convertBetweenArrayAndList();

	}
	
	
	// RSN NOTE -- Iterator moves only forward; ListItertor can move forward and Backwards
	private static void listIteratorMovesInBothDirections(){
	      ArrayList<String> list = new ArrayList<String>();
	         
	        list.add("ONE");
	         
	        list.add("TWO");
	         
	        list.add("THREE");
	         
	        list.add("FOUR");
	         
	        //RSN NOTE ListIterator
	        ListIterator iterator = list.listIterator();
	         
	        System.out.println("Elements in forward direction");
	         
	        while (iterator.hasNext())
	        {
	            System.out.println(iterator.next());
	        }
	         
	        System.out.println("Elements in backward direction");
	         
	        while (iterator.hasPrevious())
	        {
	            System.out.println(iterator.previous());
	        }
	}

	/*
	 * Many are of the assumption that multiple insertion and removal operations on ArrayList will decrease the 
	 * performance of an application. But, there will be no significant change in the performance of an application
	 *  if you use ArrayList instead of arrays. 
	 * Below example shows time taken to add 1000 string elements to ArrayList and array.
	 */
	private static void arrayInserionTime() {
		   String[] namesArray = new String[1000];
		   
	        long startTime = System.nanoTime();
	 
	        for (int i = 0; i < namesArray.length; i++)
	        {
	            namesArray[i] = "Name"+i;
	        }
	 
	        long endTime = System.nanoTime();          
	 
	        System.out.println("Time taken by Array : "+(endTime - startTime)/1000+"us");
	 
	        ArrayList<String> nameList = new ArrayList<String>();     
	 
	        startTime = System.nanoTime();
	 
	        for (int i = 0; i <= 1000; i++)
	        {
	            nameList.add("Name"+i);
	        }
	 
	        endTime = System.nanoTime();
	 
	        System.out.println("Time taken by ArrayList : "+(endTime-startTime)/1000+"us");

	}
	
	private static void reverseElementInList(){
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i <= 10; i++) numbers.add(i);
		 
		System.out.println("List before reversing: " + numbers);
		 
		Collections.reverse(numbers);
		 
		System.out.println("List after reversing: " + numbers);

	}
	
	private static void convertBetweenArrayAndList(){
		List<String> listNames = Arrays.asList("John", "Peter", "Tom", "Mary", "David", "Sam");
		 
		List<Integer> listNumbers = Arrays.asList(1, 3, 5, 7, 9, 2, 4, 6, 8);
		 
		System.out.println(listNames);
		System.out.println(listNumbers);
	}
	
	
	/*
By default, ArrayList and LinkedList are not thread-safe, so if you want to use them in concurrent context,
 you have to synchronize them externally using the Collections.synchronizedList() static method which returns a 
 synchronized list that wraps the specified list. For example:
	 */
	private static void concurrentList(){
		List<Object> unsafeList = new ArrayList<Object>();
		List<Object> safeList = Collections.synchronizedList(unsafeList);
		
		/*
		 * Note that you must manually synchronize the returned list when iterating over it, for example:
		 */
		synchronized (safeList) {
		    Iterator<Object> it = safeList.iterator();
		    while (it.hasNext()) {
		        System.out.println(it.next());
		    }
		}
	}

}
