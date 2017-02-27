package concurrency;

/*
 * How to create thread
 * How to Name a thread
 * Thread.currentThread.
 * Thread.getId
 */
class ASampleThread extends Thread {//method where the thread execution will start 
	
	int count=0;
	
	public void run(){
		//logic to execute in a thread  
		System.out.println("Thread name:" + this.getName());
		
		System.out.println("Thread state : " +this.getName() + this.getState());
		
		//Thread.currentThread    Thread.getId()
		System.out.println("Thread id : " +Thread.currentThread().getName() + " "+ this.getId() +
				Thread.currentThread().isDaemon());
		
		try {
			this.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread state : " + this.getName() + this.getState());
		
	}
	//let’s see how to start the threads
	public static void main(String[] args){
		Thread t1 = new ASampleThread();
		t1.setName("RThead1");
		
		//System.out.println("Thread state : " + t1.getState());
		
		Thread t2 = new ASampleThread();
		t2.setName("RThread2");
		//t1.run(); t2.run();
		t1.start();  //start the first thread. This calls the run() method.
		//t2.start(); //this starts the 2nd thread. This calls the run() method.  
		
	}
} 
