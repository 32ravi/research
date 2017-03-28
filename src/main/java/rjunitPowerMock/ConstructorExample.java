package rjunitPowerMock;

public class ConstructorExample {
	
	public String getMeSimpleObject() {
		SimpleClass simpleClass = new SimpleClass();
		
		String returnValue = simpleClass.getMeCurrentDateAsString();
		return returnValue;
	}
}