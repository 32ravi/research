package ds.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetDemoBulkOps {

	public static void main(String[] args) {
		//----- Performing Bulk Operations between two Sets

		//We can perform some mathematic-like operations between two sets such as subset, union, intersection 
		//and set difference. 

		System.out.println("\nSET Bulk Operations-----");

		//---SUBSET Operation
		Set<Integer> s1 = new HashSet<>(Arrays.asList(20, 56, 89, 31, 8, 5));
		Set<Integer> s2 = new HashSet<>(Arrays.asList(8, 89));

		if (s1.containsAll(s2)) {
			System.out.println("s2 is a subset of s1");
		}

		if (s2.containsAll(s1)) {
			System.out.println("s1 is NOT a subset of s2");
		}
		//----UNION Operation
		//s1.addAll(s2) — transforms s1 into the union of s1 and s2.
		//(The union of two sets is the set containing all of the elements contained in either set.)
		
		System.out.println("----UNION-----");
		Set<Integer> su1 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9));
		Set<Integer> su2 = new HashSet<>(Arrays.asList(2, 4, 6, 8));
		 
		System.out.println("before union su1=" + su1 + " su2= " + su2);
		 
		su1.addAll(su2);
		 
		System.out.println("su1 after union: " + su1);
		
		//INTERSECTION Operation
		//The intersection of two sets is the set containing only the elements common to both sets.)
		
		System.out.println("----INTERSECTION-----");
		Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
		Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 4, 6, 8));
		 
		System.out.println("before intersection: set1 = " + set1 + " set2= " + set2);
		 
		set1.retainAll(set2);
		 
		System.out.println("set1 after intersection: " + set1);

		//SET difference
		//s1.removeAll(s2) — transforms s1 into the (asymmetric) set difference of s1 and s2. 
		//(For example, the set difference of s1 minus s2 is the set containing all of the elements found in s1 but not in s2
		
		System.out.println("----DIFFERENCE-----");
		Set<Integer> se1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7, 9));
		Set<Integer> se2 = new HashSet<>(Arrays.asList(2, 4, 6, 8));
		 
		System.out.println("before difference se1= " + se1 + " se2=" + se2);
		 
		se1.removeAll(se2);
		     
		System.out.println("se1 after difference: " + se1);

	}

}
