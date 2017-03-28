package rjunit;


public class MyUnit {
	
	public static MyUnit unit = new MyUnit();
	
	public String concatenate(String one, String two){
		return one + two;
	}

	public MyUnit getTheSameObject() {
		return unit;
		//return new MyUnit();
		//turn null;
	}

	public MyUnit getTheObject() {
		
		return unit;
	}

	public String[] getTheStringArray(){
		return new String[] {"one", "two", "three"};
	}

	public boolean getTheBoolean(){
		return true;
	}
	
	public String getConstantObject(){
		return "constant string";
	}
}