package rjunit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;

/*
 * 3. @Rule ExpectedException
This ExpectedException rule (since JUnit 4.7) let you test both the exception type and also the exception detail, 
same like “2. Try-catch and always fail()” method, but in a more elegant way :
 */
public class Exception3Test {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testDivisionWithException() {

        thrown.expect(ArithmeticException.class);
        thrown.expectMessage(containsString("/ by zero"));

        int i = 1 / 0;

    }

    @Test
    public void testNameNotFoundException() throws NameNotFoundException {

		//test type
        thrown.expect(NameNotFoundException.class);

		//test message
        thrown.expectMessage(is("Name is empty!"));

        //test detail
        thrown.expect(hasProperty("errCode"));  //make sure getters n setters are defined.
        thrown.expect(hasProperty("errCode", is(666)));

        CustomerService cust = new CustomerService();
        cust.findByName("");

    }
    
    //==================================================
	//Class definition
	
    class NameNotFoundException extends Exception {

        private int errCode;

        public NameNotFoundException(int errCode, String message) {
            super(message);
            this.errCode = errCode;
        }

        public int getErrCode() {
            return errCode;
        }

        public void setErrCode(int errCode) {
            this.errCode = errCode;
        }
    }
    
    class CustomerService {

        public Customer findByName(String name) throws NameNotFoundException {

            if ("".equals(name)) {
                throw new NameNotFoundException(666, "Name is empty!");
            }

            return new Customer(name);

        }

    }
    
    class Customer{
    	
    	public Customer(String n){
    		
    	}
    	
    	
    }
    

}