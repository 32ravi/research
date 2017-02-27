package concurrency;

import java.util.concurrent.ExecutorService;

/*
Java Thread pool represents a group of worker threads that are waiting for the job and reuse many times.

In case of thread pool, a group of fixed size threads are created. 
A thread from the thread pool is pulled out and assigned a job by the service provider. 
After completion of the job, thread is contained in the thread pool again.

Advantage of Java Thread Pool

Better performance It saves time because there is no need to create new thread.
 */

import java.util.concurrent.Executors;

/*
 * 
 */
public class A_IMP_ThreadPoolTest { 
	
	 static class  Worker implements Runnable
	 {  
	    private String message;  
	    public Worker(String s){  
	        this.message=s;  
	    }  
	     public void run() {  
	        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);  
	        processmessage();//call processmessage method that sleeps the thread for 2 seconds  
	        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name  
	    }  
	    private void processmessage() {  
	        try {  Thread.sleep(2000);  } catch (InterruptedException e) { e.printStackTrace(); }  
	    }  
	}  
	
    public static void main(String[] args) {  
    	
       ExecutorService executor = Executors.newFixedThreadPool(2);//creating a pool of 5 threads  
       //ExecutorService executor = Executors.newWorkStealingPool(2);//creating a pool of 5 threads  
        
       for (int i = 0; i < 10; i++) {  
           Runnable worker = new Worker("" + i);  
           executor.execute(worker);//calling execute method of ExecutorService  
           System.out.print("inside for loop i " + i + "\n");
         }  
       executor.shutdown();  
       while (!executor.isTerminated()) {   }  
 
       System.out.println("Finished all threads");  
   }  
}  