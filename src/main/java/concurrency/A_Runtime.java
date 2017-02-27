package concurrency;

public class A_Runtime {
	
	public static void main(String [] args)
	{
		Runtime env = Runtime.getRuntime();
		System.out.println("Processor : " + env.availableProcessors());
		
		System.out.println("maxMemory : " + env.maxMemory() + " mem " + env.totalMemory());
	}

}
