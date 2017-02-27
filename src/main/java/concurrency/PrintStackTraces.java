package concurrency;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/*
 * Learn
 * "take" and "put" methods of a Q are Blocking calls.
 * 
 * This example demonstrates that writer thread will be blocked till another slot is available in the blocking Q.
 * Reader is going to keep pulling record and will make another slot available to writer thread.
 */
public class PrintStackTraces {

	public static void main(String[] args)  {
		
		
		ArrayBlockingQueue<String> blockingQ = new ArrayBlockingQueue<String>(5);
		
		blockingQ.add("Tom0");
		
		
	/*	try {
			System.out.println("... just before calling offer with timeout on a full Q....");
			blockingQ.offer("Tim", 1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	*/	
		
		//Start a reader thread on blockingQ
		new Thread( () -> {
			int i =0;
			while(i< 2){
				try {
					String takenElement = blockingQ.take();
					System.out.println(Thread.currentThread().getName() + " take " + takenElement);
					Thread.sleep(5000);

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				i++;
			}
			System.out.println(Thread.currentThread().getName() + " exiting..Q remaining =" + blockingQ.toString());
		},"Reader").start();

		
		//Start a writer thread
		new Thread( () ->{
			int i=0;
			while(i<2){
				try {
					String toAdd = "Tom"+i;
					System.out.println(Thread.currentThread().getName() + " ....adding "+ toAdd );
					blockingQ.put("Tom"+i);  //====NOTE=====>>> NOTE this is blocking call
					System.out.println(Thread.currentThread().getName() + " Q =" + blockingQ.toString());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
			}
		},"Writer").start();
		
		//====NOTE=====>>> PRINT STACK TRACE
		
		Map<Thread, StackTraceElement[]> allStacks  = Thread.getAllStackTraces();
		System.out.println("---------Total Thread count = " + allStacks.size());
		
		System.out.println(allStacks.values().toString());
		
		//todo loop through this array to print all the stacks
		
		
		
	}

}
