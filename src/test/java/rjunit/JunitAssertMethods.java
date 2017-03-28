package rjunit;

import org.junit.Test;
import static org.junit.Assert.*;

/*
Here is a list of the assert methods:

assertArrayEquals()
assertEquals()
assertTrue() + assertFalse()
assertNull() + assertNotNull()
assertSame() + assertNotSame()
assertThat()
Throughout the rest of this text I will explain how these assert methods work, and show you examples of how to use them. The examples will test an imaginary class called MyUnit. The code for this class is not shown, but you don't really need the code in order to understand how to test it.
 */

public class JunitAssertMethods {

	//public MyUnit unit = new MyUnit();


	@Test
	public void testGetTheStringArray() {
		MyUnit myUnit = new MyUnit();

		String[] expectedArray = {"one", "two", "three"};

		String[] resultArray =  myUnit.getTheStringArray();

		assertArrayEquals(expectedArray, resultArray);
	}


	@Test
	public void testConcatenate() {
		MyUnit myUnit = new MyUnit();

		String result = myUnit.concatenate("one", "two");

		assertEquals("onetwo", result);
	}

	@Test
	public void testGetTheBoolean() {
		MyUnit myUnit = new MyUnit();

		assertTrue (myUnit.getTheBoolean());

		assertFalse(myUnit.getTheBoolean());
	}

	//RSN assertNull
	@Test
	public void testGetTheObject() {
		MyUnit myUnit = new MyUnit();

		assertNull(myUnit.getTheObject());

		assertNotNull(myUnit.getTheObject());
	}

	//RSN assertSame NotSame
	@Test
    public void testGetTheSameObject() {
        MyUnit myUnit = new MyUnit();

        assertSame   (myUnit.getTheSameObject(),
                      myUnit.getTheSameObject());
        
        assertNotSame(myUnit.getTheSameObject(),
                      myUnit.getTheSameObject());
    }

	//=======Test Object===========================================
	
	/*public class MyUnit {
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
	}*/
}
