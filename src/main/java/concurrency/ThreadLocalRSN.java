package concurrency;

class DataClass{
	ThreadLocal<Integer> currentValue = new ThreadLocal<Integer>(){
		
		@Override
		protected Integer initialValue() { 
			return new Integer(100);
		}
	};
	
	int getNextValue(){
		int c = currentValue.get().intValue() + 1;  //====NOTE=====>>> RSN NOTE IMP Check ThreadLocal.get()set() method
		  
		currentValue.set(new Integer(c));
		return currentValue.get().intValue();
	}
	
	//currentValueUnsafe is not thread safe.
	Integer currentValueUnsafe = new Integer(1);
	
	int getNextValueNonLocal(){
		int c = currentValueUnsafe.intValue() + 1;
		currentValueUnsafe = new Integer(c);
		return c;
	}
}

public class ThreadLocalRSN {
	public static void main(String[] args) {

		DataClass data = new DataClass();
		
		new Thread( () -> {
			int counter=0;
			while(counter <10 ){
				System.out.println(Thread.currentThread().getName() + "    value =" +	data.getNextValue());
				System.out.println( Thread.currentThread().getName() +"unsafe:" + data.getNextValueNonLocal());
				counter++;
			}
		}
		,"T1").start();


		new Thread( () -> {
			int counter=0;
			while(counter < 10){
				System.out.println("                  " + Thread.currentThread().getName() + "value =" +	data.getNextValue());
				System.out.println( "                       " +  Thread.currentThread().getName() +"unsafe:" + data.getNextValueNonLocal());

				counter++;
			}
		}
		,"T2").start();

	}

}
