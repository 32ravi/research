package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
	
	
	public static void main(String[] args){
	
		AtomicInteger atom = new AtomicInteger();
		
		System.out.println(" ");
		System.out.println("set: " + atom.addAndGet(10));
		
		System.out.println("compareSet: " + atom.compareAndSet(10, 22));
		
		System.out.println("get: " + atom.get());

		System.out.println("compareSet: " + atom.compareAndSet(24, 33));
		System.out.print("get: " + atom.get());

		
	}

}
