package rjunit;

import org.junit.Test;
import java.util.ArrayList;

import static junit.framework.TestCase.fail; 
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
//NOTE hemcrest import above

/*
 * 
 * http://www.mkyong.com/unittest/junit-4-tutorial-2-expected-exception-test/
 * 
In JUnit, there are 3 ways to test the expected exceptions :


1. @Test, optional ‘expected’ attribute
2. Try-catch and always fail()
3. @Rule ExpectedException
 * 
 */
public class Exception1N2Test {
	
	// Method 1 ==================================================
	
    @Test(expected = ArithmeticException.class)
    public void testDivisionWithException() {
        int i = 1 / 0;
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyList() {
        new ArrayList<Object>().get(0);
    }
    
    //==================================================
	//Method 2  Try-catch and always fail()
    //This is a bit old school, widely used in JUnit 3. Test the exception type and also the exception detail. Refer below 
    
    @Test
    public void testDivisionWithException2() {
        try {
            int i = 1 / 0;
            fail(); //remember this line, else 'may' false positive
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), is("/ by zero"));
			//assert others
        }
    }

    @Test
    public void testEmptyList2() {
        try {
            new ArrayList<>().get(0);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), is("Index: 0, Size: 0"));
        }
    }

    

}