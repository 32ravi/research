package ds.Array;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> list = new LinkedList<>();
		
		list.add("apple");
		list.add("banana");
		list.add("pear");
		
		System.out.println(list.toString());
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		System.out.println(list.get(1));
		
		System.out.println("Contains..." + list.contains("banana"));
		
		System.out.println(list.remove("banana")); //====NOTE=====>>> compare LinkedList remove with ArrayList remove
		
		list.add(1, "BANANA");
		System.out.println(list.toString());
		System.out.println(list.remove(1));
		  //====NOTE=====>>> IMP remove operation : LinkedLIst Big O(1) arrayList Big O(2)
		
		System.out.println("Contains..." + list.contains("banana"));
		//====NOTE=====>>> IMP contains logic Big O(n) is same for Arraylist and Linked List
		
		System.out.println();
		list.clear();


	}

}
 