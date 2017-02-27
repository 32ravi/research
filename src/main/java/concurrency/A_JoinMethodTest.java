package concurrency;

/*
 * The join() method
The join() method waits for a thread to die. In other words, it causes the currently 
running threads to stop executing until the thread it joins with completes its task.
The join(long ms) method waits for given ms 
 */

class A_JoinMethodTest extends Thread{
	
	public A_JoinMethodTest(String str){
		setName(str);
	}
	public void run(){  
		for(int i=1;i<=5000;i++){  
			try{  
				Thread.sleep(500);  
			}catch(Exception e){System.out.println(e);}  
			System.out.println(Thread.currentThread().getName() + " " +i);  
		}  
	}  
	public static void main(String args[]){  
		A_JoinMethodTest t1=new A_JoinMethodTest("T1");  
		A_JoinMethodTest t2=new A_JoinMethodTest("T2");  
		A_JoinMethodTest t3=new A_JoinMethodTest("T3");  
		t1.start();
		t2.start();
		try{  
			//t1.join();
			t1.join(1500);   //basically join is a blocking call, thread from where join is called
			                 //will wait for t1 thread to die.

		}catch(Exception e){System.out.println(e);}  

		//t2.start();  
		t3.start();  
	}  
}  
