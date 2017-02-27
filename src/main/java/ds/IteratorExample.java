package ds;

import java.util.Iterator;
import java.util.function.Consumer;

/*
 * http://tutorials.jenkov.com/java-generics/implementing-iterable.html
 * Learn
 * Iterator
 * Genrics, InnerClass,
 * Enhanced for loop
 * forEach loop
 * 
 * It is possible to use your own collection type classes with the new for-loop. 
 * To do so, your class must implement the java.lang.Iterable<E> interface. Here is a very basic example:
 * 
 * 
 * http://www.javaworld.com/article/2461744/java-language/java-language-iterating-over-collections-in-java-8.html?page=2
 * 
 * Note the difference between the passive iterator in Listing 4 and the active iterator in the previous three listings. 
 * In the first three listings, the loop structure controls the iteration, and during each pass through the loop,
 *  an object is retrieved from the list and then printed. In Listing 4, there is no explicit loop. We simply tell the forEach() method what to do with 
 *  the objects in the list —
in this case we simply print the object. Control of the iteration resides within the forEach() method.
 */

public class IteratorExample {

	public static class MyCollection<E> implements Iterable<E>{

		protected E[] myArray;
		private int arraySize;
		
		public MyCollection(E[] arr)
		{
			myArray = arr;
			arraySize = arr.length;
		}

		public Iterator<E> iterator() {
			return new MyIterator<E>();
		}

		//Inner class 
		public class MyIterator<T>  implements Iterator<T> {
			private int index = 0;
			
			public boolean hasNext() {
				return index< arraySize;
			}

			@Override
			public T next() {
				return (T) myArray[index++];
			}

			@Override
			public void remove() {
				Iterator.super.remove();
			}

			
		}

		/*
		public Iterator<E> iterator() {
			return  new Iterator<E>(){   // RSN NOTE this is an anonymous class version; equivalent of above inner class code 

				private int index=0;

				public boolean hasNext() {
					return index < arraySize;
				}

				public E next() {
					return myArray[index++];
				}

				public void remove() {
					myArray[index] = null;
				}
			};
		}
		*/
	}
    
	public static void main(String[] args) {
		
		Integer[]  numbers = new Integer[] {1,2,3,4,5};   // RSN NOTE: Notice Integer array initialization
		MyCollection<Integer> intCollection = new MyCollection(numbers);
		
		// RSN NOTE: Enhanced for loop
		for(Integer abc: intCollection){ 
			// RSN NOTE : abc must be declared as Integer above, try declaring as String abc
			System.out.println(abc);
		}
		
		String[] myStrings = {"abc", "def","ageh", "ijk"};
		
		MyCollection<String> stringCollection = new MyCollection(myStrings);
		
		/*
		 Iterator<String> itr = stringCollection.iterator();
		
		for(; itr.hasNext();)
		{
			System.out.println(itr.next());
		}
		// RSN NOTE -- this commented section is re-written below
		*/
		
		for(Iterator<String> it = stringCollection.iterator(); it.hasNext(); ){ // RSN NOTE --  iterator declaration in for line
			System.out.println(it.next());
		}

			
		// RSN NOTE : Enhanced For loop
		for(String o: stringCollection){
			System.out.println(o);
		}
		
		System.out.println(" forEach output ---");
		// RSN NOTE : forEach loop + LAMBDA expression from JDK 8
		stringCollection.forEach(x -> System.out.println(x));
		
			

	}

}
