package ds.Queue;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueDemo {

	public static void main(String[] args)  {
		
		
		ArrayBlockingQueue<String> blockingQ = new ArrayBlockingQueue<String>(3);
		
		//ArrayBlockingQueue<String> blockingQ = new ArrayBlockingQueue<String>();  // NOTE -- Compiler error
		//====NOTE=====>>> All BlockingQueue Impls are **Bounded**, meaning you HAVE to give the size in constructor, and size wont' change afterwards. 
		
		ArrayList<String> aList = new ArrayList<String>();//====NOTE=====>>> initial size is not necessary; not bounded
		
		
		blockingQ.add("apple");
		blockingQ.add("banana");
		blockingQ.add("orange");
		//blockingQ.add("pear"); //====NOTE=====>>>  java.lang.IllegalStateException: Queue full 
		
		
		
		blockingQ.offer("Tom2"); //====NOTE=====>>> offer(e) won't block; offer(e,timeout,unit) will BLOCK
		
		try {
			System.out.println("... just before calling offer with timeout on a full Q....");
			blockingQ.offer("Tim", 1000, TimeUnit.MILLISECONDS);
			System.out.println("after offer...");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
				try {
					System.out.println("Before blocking put....");
					blockingQ.put("Tom1");  //====NOTE=====>>> NOTE this is blocking call
					System.out.println(Thread.currentThread().getName() + " Q =" + blockingQ.toString());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		

		
		System.out.println("blockingQ = " + blockingQ.toString());
		System.out.println("a");
		ArrayBlockingQueue<String> blockingQ2 = new ArrayBlockingQueue<String>(3);
		
		System.out.println(blockingQ2.offer("apple")); //true
		System.out.println(blockingQ2.offer("banana")); //true
		System.out.println(blockingQ2.offer("orange")); //true
		System.out.println(blockingQ2.offer("pear")); //false   //====NOTE=====>>> add Vs offer
		
		
	

	}

}
