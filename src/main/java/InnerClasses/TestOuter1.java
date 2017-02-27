package InnerClasses;

class TestOuter1{  
	static int data=30;  
	static class Inner{  
		static void msg(){System.out.println("data is "+data);}  
	}  
	public static void main(String args[]){  
		TestOuter1.Inner.msg();
		
		//If method msg was not static below section is required.
		/*TestOuter1.Inner obj=new TestOuter1.Inner();  
		obj.msg();  */
		//In this example, you need to create the instance of static nested class because it has instance method msg(). But you don't need to create the object of Outer class because nested class is static and static properties, methods or classes can be accessed without object.
	}  
	
	
}  
