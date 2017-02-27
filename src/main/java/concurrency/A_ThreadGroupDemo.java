package concurrency;

/*
Java provides a convenient way to group multiple threads in a single object. 
In such way, we can suspend, resume or interrupt group of threads by a single method call.

Note: Now suspend(), resume() and stop() methods are deprecated. 
 */

public class A_ThreadGroupDemo implements Runnable{  
	public void run() {  
		System.out.println(Thread.currentThread().getName());  
	}  
	public static void main(String[] args) {  
		A_ThreadGroupDemo runnable = new A_ThreadGroupDemo();  
		ThreadGroup tg1 = new ThreadGroup("Parent ThreadGroup");  

		Thread t1 = new Thread(tg1, runnable,"one");  
		t1.start();  
		Thread t2 = new Thread(tg1, runnable,"two");  
		t2.start();  
		Thread t3 = new Thread(tg1, runnable,"three");  
		t3.start();  

		tg1.interrupt();
		System.out.println("Thread Group Name: "+tg1.getName());  
		tg1.list();  

	}  
}  