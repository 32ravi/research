package concurrency;

/*
Thread priorities do work on most OS's but they often have minimal effect. Priorities help to order the threads that are in the run queue only and will not change how often the threads are run in any major may unless you are doing a ton of CPU in each of the threads.

Your program looks to use a lot of CPU but unless you have fewer cores than there are threads, you may not see any change in output order by setting your thread priorities. If there is a free CPU then even a lower priority thread will be scheduled to run.

Also, threads are never starved. Even a lower priority thread will given time to run quite often in such a situation as this. You should see higher priority threads be given time sliced to run more often but it does not mean lower priority threads will wait for them to finish before running themselves.

Even if priorities do help to give one thread more CPU than the others, threaded programs are subject to race conditions which help inject a large amount of randomness to their execution. What you should see however, is the max priority thread is more likely to spit out its 0 message more often than the rest. If you add the priority to the println(), that should become obvious over a number of runs.

It is also important to note that System.out.println(...) is synchronized method that is writing IO which is going to dramatically affect how the threads interact and the different threads are blocking each other.
 In addition, Thread.yield(); can be a no-op depending on how the OS does its thread scheduling.
 */

public class AThreadPriorityTest extends Thread {

	public AThreadPriorityTest(String str){
		super(str);
	}
	public void run(){  
		for(int i=1;i<=5;i++){  
			/*try{  
				Thread.sleep(500);  
			}catch(Exception e){System.out.println(e);}*/  
			System.out.println(Thread.currentThread().getName() + " " +i);  
		}  
	}  
	public static void main(String args[]){  
		AThreadPriorityTest t1=new AThreadPriorityTest("T1");  
		AThreadPriorityTest t2=new AThreadPriorityTest("T2");  
		AThreadPriorityTest t3=new AThreadPriorityTest("T3");  
		
		t1.setPriority(MAX_PRIORITY);
		t2.setPriority(MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();  
	}  


}
