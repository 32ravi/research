package InnerClasses;

class TestMemberOuter1{  
	private int data=30;  
	class Inner{  
		void msg(){System.out.println("data is "+data);}  
	}  
	public static void main(String args[]){  
		TestMemberOuter1 obj=new TestMemberOuter1();  
		TestMemberOuter1.Inner in= obj.new Inner();  
		//TestMemberOuter1.Inner in= new TestMemberOuter1.Inner();
		in.msg();  
	}  
}  