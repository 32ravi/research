package concurrency;

class Customer{  
	int amount=10000;  

	synchronized void withdraw(int amount){  
		System.out.println("going to withdraw...");  

		if(this.amount<amount){  
			System.out.println("Less balance; waiting for deposit...");  
			try{wait();}catch(Exception e){}  
		}  
		this.amount-=amount;  
		System.out.println("withdraw completed...");  
	}  

	synchronized void deposit(int amount){  
		System.out.println("going to deposit..."); 
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		this.amount+=amount;  
		System.out.println("deposit completed... ");  
		notify();  
	}  
}  

class A_waitNotify{  
	public static void main(String args[]){  
		final Customer c=new Customer();  
		
		//IMP
		new Thread(){  
			public void run(){c.withdraw(15000);}  //try c.withdraw(1000); sequencw will be different
		}.start();  
		
		new Thread(){  
			public void run(){c.deposit(10000);}  
		}.start();  

	}}  