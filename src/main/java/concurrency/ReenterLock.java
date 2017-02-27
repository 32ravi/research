package concurrency;


/*
 * Todo This program never unlocks, need to be modified.
 * 
 * Notice how the while loop (spin lock) now also takes the thread that locked the Lock instance into consideration. If either the lock is unlocked (isLocked = false) or the calling thread is the thread that locked the Lock instance, the while loop will not execute, and the thread calling lock() will be allowed to exit the method.

Additionally, we need to count the number of times the lock has been locked by the same thread. Otherwise, a single call to unlock() will unlock the lock, even if the lock has been locked multiple times. We don't want the lock to be unlocked until the thread that locked it, has executed the same amount of unlock() calls as lock() calls.

The Lock class is now reentrant.

http://tutorials.jenkov.com/java-concurrency/locks.html
 */

public class ReenterLock {

	boolean isLocked = false;
	Thread  lockedBy = null;
	int     lockedCount = 0;

	public synchronized void lock()
			throws InterruptedException{
		Thread callingThread = Thread.currentThread();
		while(isLocked && lockedBy != callingThread){
			System.out.println(Thread.currentThread().getName() + "      b4 lock");
			wait();
			System.out.println(Thread.currentThread().getName() + "      after lock " + lockedCount);
		}
		isLocked = true;
		lockedCount++;
		lockedBy = callingThread;
	}


	public synchronized void unlock(){
		if(Thread.currentThread() == this.lockedBy){
			lockedCount--;

			if(lockedCount == 0){
				isLocked = false;
				System.out.println(Thread.currentThread().getName() + " b4 unlock ");
				
				notify();
				System.out.println(Thread.currentThread().getName() + " after unlock " + lockedCount );
			}
		}
		

	}
	
	public static void main(String[] args) {
		
	  ReenterLock myLock = new ReenterLock();

	  new Thread( () -> {
		  for (int i=0; i<10; i++){
		  try {
			 
				  myLock.lock();
				  Thread.sleep(1);
				  myLock.unlock();
			  } catch (InterruptedException e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  }
		  }
	  },"T1-").start();


	  new Thread( () -> {
		  for (int j=0; j<10; j++){
			  try {
				  myLock.lock();
				  Thread.sleep(1);
				  myLock.unlock();
			  } catch (InterruptedException e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  }
		  }
	  },"T2").start();

	}
	
	
}
