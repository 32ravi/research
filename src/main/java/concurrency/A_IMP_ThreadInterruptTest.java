package concurrency;

import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.System;
import java.lang.Thread;


/*
 * https://10kloc.wordpress.com/2013/03/03/java-multithreading-steeplechase-stopping-threads/
 * 
 Once you start a thread, nothing can (safely) stop it, except the thread itself. At most, the thread could be simply asked – or interrupted – to stop itself.
Hence in Java, stopping threads is a two step procedure:

1. Sending stop signal to thread – aka interrupting it
2. Designing threads to act on interruption
A thread in Java could be interrupted by calling `Thread.interrupt()` method.
 Threads can check for interruption by calling `Thread.isInterrupted()` method. 
 A good thread must check for interruption at regular intervals. 
 The following code fragment illustrates this:
 
A thread can check for interruption at regular intervals – e.g. as a loop condition – 
and take action when it is interrupted. Life would have been easy if it weren’t for those pesky 
blocking methods: these methods may “block” and take a long time to return, effectively delaying the c

*/

public class A_IMP_ThreadInterruptTest {
	public static void main(String[] args) throws Exception {
		 
        /**
         * A Thread which is responsive to Interruption.
         */
        class ResponsiveToInterruption extends Thread {
            @Override public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("[Interruption Responsive Thread] Alive");
                }
                System.out.println("[Interruption Responsive Thread] bye**");
 
            }
        }
 
        /**
         * Thread that is oblivious to Interruption. It does not even check it's
         * interruption status and doesn't even know it was interrupted.
         */
        class ObliviousToInterruption extends Thread {
            @Override public void run() {
                while (true) {
                    System.out.println("[Interruption Oblivious Thread] Alive");
                    
                    try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
                // The statement below will never be reached.
                //System.out.println("[Interruption Oblivious Thread] bye");
            }
        }
        
        class InterruptionToBlockingMethods extends Thread{
        	@Override public void run(){
        		while(true)
        		{
        			System.out.println("Before sleep....");
        			try {
        				Thread.sleep(5000);
        			} catch (InterruptedException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        				break;
        			}
        		}
        	}
        }
 
        Thread theGood = new ResponsiveToInterruption();
        Thread theUgly = new ObliviousToInterruption();
        Thread blockedThread = new InterruptionToBlockingMethods();
 
        theGood.start();
        theUgly.start();
        blockedThread.start();
 
        theGood.interrupt(); // The thread will stop itself
        theUgly.interrupt(); // Will do nothing
        
        blockedThread.interrupt();
}
}
