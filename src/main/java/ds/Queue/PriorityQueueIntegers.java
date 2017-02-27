package ds.Queue;

import java.util.PriorityQueue;

/*
 * You already know that if you don’t supply the Comparator while creating a PriorityQueue, elements will be ordered in 
 * natural ascending order. 
 * In this example, we create a PriorityQueue of Integers without supplying a Comparator like this,
 */

public class PriorityQueueIntegers {

	public static void main(String[] args) {
		 //Creating a PriorityQueue with default Comparator.
		 
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
 
        //Inserting elements into pQueue.
 
        pQueue.offer(21);
 
        pQueue.add(17); //====NOTE=====>>> add and offer are same; just return types/error are different
 
        pQueue.offer(37);
 
        pQueue.offer(41);
 
        pQueue.offer(9);
 
        pQueue.offer(67);
 
        pQueue.offer(31);
 
        //Removing the head elements
        
        System.out.println(pQueue.peek());     //Output : 9, Read but NOT remove
 
        System.out.println(pQueue.poll());     //Output : 9
 
        System.out.println(pQueue.element());    //====NOTE=====>>> element and peek are same //Output : 17
        System.out.println(pQueue.remove());    //====NOTE=====>>> remove and poll are same //Output : 17
 
        System.out.println(pQueue.poll());     //Output : 21
 
        System.out.println(pQueue.poll());     //Output : 31
 
        System.out.println(pQueue.poll());     //Output : 37
 
        System.out.println(pQueue.poll());     //Output : 41
 
        System.out.println(pQueue.poll());     //Output : 67

	}

}
