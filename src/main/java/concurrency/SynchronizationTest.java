package concurrency;


class SynchronizationTest{
	
	public static class Table{  

		//int nn
		//synchronized void printTable(int n){//method is synchronized  
		void printTable(int n){//method not synchronized  
			for(int i=1;i<=5;i++){  
				System.out.println(Thread.currentThread().getName() + " " +n*i);  
				try{  
					Thread.sleep(400);  
				}catch(Exception e){System.out.println(Thread.currentThread().getName() + " " +e);}  
			}  

		}  
	}  

	static class MyThread1 extends Thread{  
		Table t;  
		MyThread1(Table t)
		{
			super("T1");
			this.t=t;  
		}  
		public void run(){  
			t.printTable(5);  
		}  

	}  
	static class MyThread2 extends Thread{  
		Table t;  
		
		MyThread2(Table tx){
			super("T2");
			this.t=tx;  
		}  
		
		public void run(){  
			t.printTable(100);  
		}  
	}  

	
	public static void main(String args[]){  
		Table obj = new Table();//only one object  
		MyThread1 t1=new MyThread1(obj);  
		MyThread2 t2=new MyThread2(obj);  
		t1.start();  
		t2.start();  
	}  
}  