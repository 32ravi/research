package concurrency;

class A_Thread extends Thread {//method where the thread execution will start 
	
	public void run(){
		//logic to execute in a thread  
		System.out.println("Thread name...:" + this.getName());
	
	}
	//let’s see how to start the threads
	public static void main(String[] args){
		Thread t1 = new A_Thread();
		t1.setName("RThead1");
		
		t1.start();  //start the first thread. This calls the run() method.
	}
} 
