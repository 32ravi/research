package concurrency;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Statistic {
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private int value;
	public void increment() {
		lock.writeLock().lock();
		try {
			value++;
		} finally {
			lock.writeLock().unlock();
		}
	}
	public int current() {
		lock.readLock().lock();
		try {
			return value;
		} finally {
			lock.readLock().unlock();
		}
	}
}

public class ReadWriteLockTest{
	public static void main(String[] args){

		final Statistic aStat = new Statistic();

		new Thread( new Runnable(){
			public void run(){
				for(int i=0; i< 10; i++){
					aStat.increment();
				}
			}
		}).start();

		new Thread( new Runnable(){
			public void run(){
				for(int j=0;j<10; j++){
					System.out.println("Current :" + aStat.current());
				}
			}
		}).start();
		
		
		///- Lambda same as above
		new Thread( () -> {
			for (int k=0;k<10; k++){
				System.out.println("current : " + aStat.current());
			}
		}).start();

	}


}