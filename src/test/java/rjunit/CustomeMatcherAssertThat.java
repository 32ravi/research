package rjunit;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;



/*
Matchers is an external addition to the JUnit framework. Matchers were added by the framework called Hamcrest.
 JUnit 4.8.2 ships with Hamcrest internally, so you don't have to download it, and add it yourself.
Matchers are used with the org.junit.Assert.assertThat() method, which looks like this:

    public void assertThat(Object o, Matcher matcher){
        ...
    }
InBuilt Matchers

Core=======
any()	Matches anything
is()	A matcher that checks if the given objects are equal.
describedAs()	Adds a descrption to a Matcher
Logical=======
allOf()	Takes an array of matchers, and all matchers must match the target object.
anyOf()	Takes an array of matchers, and at least one of the matchers must report that it matches the target object.
not()	Negates the output of the previous matcher.
Object=========
equalTo()	A matcher that checks if the given objects are equal.
instanceOf()	Checks if the given object is of type X or is compatible with type X
notNullValue() + 
nullValue()	Tests whether the given object is null or not null.
sameInstance()	Tests if the given object is the exact same instance as another.

 */
public class CustomeMatcherAssertThat {
	
	@Test
	public void testAssertThat() {

	    assertThat(123,  is(123)  );
	    
	    assertThat("red car",  is("red car")  );
	}
	
	@Test
	public void testWithMultipleMatchers() {
	    assertThat(123, not( is(345) ) );
	}
	
	@Test
	public void testCustomMatches() {
	    MyUnit myUnit = new MyUnit();

	    assertThat(myUnit.getConstantObject(), customMatch("constant string"));
	    
	   assertThat(myUnit.getConstantObject(), customMatch("constant stringRRR")); // Negative test case

	}
	
	
	//====NOTE=====>>> Write Own Custom Matches class
	//Anonyms Inner class 
	//Should extend BaseMatcher and MUST implement two methods - matches and describeTo
	public static Matcher customMatch(final Object expected){

	    return new BaseMatcher() {

	        protected Object theExpected = expected;
            
	        //RSN implement matches method
	        public boolean matches(Object o) {
	            return theExpected.equals(o);
	        }

	        //RSN implement describeTo method
	        public void describeTo(Description description) {
	            description.appendText(theExpected.toString());
	        }
	    };
	
	}	
	
	

}
