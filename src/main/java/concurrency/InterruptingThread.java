package concurrency;

public class InterruptingThread extends Thread{  

	public void run(){  
		for(int i=1;i<=100;i++){  
			if(Thread.interrupted()){  
				System.out.println("code for interrupted thread");  
				break;
			}  
			else{  
				System.out.println("code for normal thread");  
			}  
			
			/*try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}*/

		}//end of for loop  
	}  

	public static void main(String args[]) throws InterruptedException{  

		InterruptingThread t1=new InterruptingThread();  
		InterruptingThread t2=new InterruptingThread();  

		t1.start();
		Thread.sleep(1);
		t1.interrupt();  

		//t2.start();  

	}  
}  