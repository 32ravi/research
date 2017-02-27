package ds.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*
 * • LinkedHashSet: This implementation orders its elements based on insertion order.
 *  So consider using a LinkedHashSet when you want to store unique elements in order.

 */
public class LinkedHashSetDemo {

	public static void main(String[] args) {
		
		basicLinkedHashSetPerservesInsertionOrder();
		
		try{
			linkedHashSetFailFastIterator();
		}
		catch(Exception e){
			System.out.println("exception from linkedHashSetFailFastIterator() : " + e );
		}
		
		noDuplicatesOnlyOneNullAllowed();

	}


	private static void basicLinkedHashSetPerservesInsertionOrder() {
		 //Creating LinkedHashSet
		 
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        //Set<String> set = new HashSet<String>();  //Output [JAVA, HIBERNATE, JSP, JDBC, J2EE, STRUTS]
 
        //Adding elements to LinkedHashSet
		set.add("JAVA");
		set.add("J2EE");
		set.add("STRUTS");
		set.add("JSP");
		set.add("JDBC");
		set.add("HIBERNATE");
 
        //Printing elements of LinkedHashSet
        System.out.println("order by insertion :" +set);   //[JAVA, J2EE, STRUTS, JSP, JDBC, HIBERNATE]  
                               //if HashSet is used : output : [JAVA, HIBERNATE, JSP, JDBC, J2EE, STRUTS]
		
	}
	
	private static void linkedHashSetFailFastIterator() {
		//Creating LinkedHashSet
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		//Adding elements to LinkedHashSet

		set.add("JAVA");
		set.add("J2EE");
		set.add("STRUTS");
		set.add("JSP");
		set.add("JDBC");
		set.add("HIBERNATE");

		//Getting Iterator object
		Iterator<String> it = set.iterator();

		//Modifying the LinkedHashSet after the Iterator is created
		set.add("JSF");

		while (it.hasNext())
		{
			//This statement will throw ConcurrentModificationException

			System.out.println(it.next());
		}
	}
	
	private static void noDuplicatesOnlyOneNullAllowed(){
		 //Creating LinkedHashSet
		 
        LinkedHashSet<String> set = new LinkedHashSet<String>();
 
        //Adding elements to LinkedHashSet
 
        set.add("BLUE");
 
        set.add("RED");
 
        set.add("GREEN");
 
        set.add("BLUE");     //duplicate element
 
        set.add("BLACK");
 
        set.add("WHITE");
 
        //Adding two null elements
 
        set.add(null);
 
        set.add(null);
 
        //printing the elements of LinkedHashSet
 
        System.out.println(set);     //Output : [BLUE, RED, GREEN, BLACK, WHITE, null]
 
        //You can notice that LinkedHashSet doesn't allow duplicates and allows only one null element
    }
}

	
