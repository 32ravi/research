package rjunit;

import static org.mockito.Mockito.*;
import java.awt.List;
import java.util.LinkedList;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/*
 http://static.javadoc.io/org.mockito/mockito-core/2.7.17/org/mockito/Mockito.html
 
 	<dependency>
       <groupId>org.mockito</groupId>
       <artifactId>mockito-all</artifactId>
       <version>1.9.5</version>
    </dependency>
 */

public class RSN_MockitoDemo {

	//Shorthand for Mock creation using annotation.
	@Mock private  LinkedList mockedList;


	/**
	 Spying on real objects======
You can create spies of real objects. When you use the spy then the real methods are called (unless a method was stubbed).
Real spies should be used carefully and occasionally, for example when dealing with legacy code.
Spying on real objects can be associated with "partial mocking" concept. 
Before the release 1.8, Mockito spies were not real partial mocks. The reason was we thought partial mock is a code smell. At some point we found legitimate use cases for partial mocks (3rd party interfaces, interim refactoring of legacy code, the full article is here)
	 */

	@Test
	public void testSpy(){
		System.out.println("in testSpy...");
		
		LinkedList list = new LinkedList();
		LinkedList spy = Mockito.spy(list);

		//optionally, you can stub out some methods:
		Mockito.when(spy.size()).thenReturn(100);

		//using the spy calls *real* methods
		spy.add("one");
		spy.add("two");

		//prints "one" - the first element of a list
		System.out.println(spy.get(0));

		//size() method was stubbed - 100 is printed
		System.out.println(spy.size());

		//optionally, you can verify
		verify(spy).add("one");
		verify(spy).add("two");

	}

	@Test
	public void mockDemo(){
		// mock creation
		List mockedList = mock(List.class);

		// using mock object - it does not throw any "unexpected interaction" exception
		mockedList.add("one");
		mockedList.clear();

		// selective, explicit, highly readable verification
		verify(mockedList).add("one");  // Try chaning "one" to "onex" and test will fail
		verify(mockedList).clear();
	}

	@Test
	public void testStubbing(){
		// you can mock concrete classes, not only interfaces
		LinkedList mockedList = mock(LinkedList.class);

		// stubbing appears before the actual execution
		when(mockedList.get(0)).thenReturn("first");

		// the following prints "first"
		System.out.println(mockedList.get(0));

		// the following prints "null" because get(999) was not stubbed
		System.out.println(mockedList.get(999));
	}


	/*
	 Mockito verifies argument values in natural java style: by using an equals() method. 
	 Sometimes, when extra flexibility is required then you might use argument matchers:
	 */
	@Test
	public void testArgumentMatcher(){

		LinkedList mockedList = mock(LinkedList.class);

		//stubbing using built-in anyInt() argument matcher
		when(mockedList.get(anyInt())).thenReturn("element");

		//stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
		// when(mockedList.contains(argThat(isValid()))).thenReturn("element");

		//following prints "element"
		System.out.println(mockedList.get(999));  // RSN IMP comment out this line and then run to see the details

		//you can also verify using an argument matcher
		verify(mockedList).get(anyInt());

		//argument matchers can also be written as Java 8 Lambdas
		//verify(mockedList).add(argThat(someString -> ((String) someString).length() > 5));
	}

	/*
	 * 
	 */
	@Test
	public void testExactNumberOfInvocationsCalled(){
		LinkedList mockedList = mock(LinkedList.class);

		//@Mock private final LinkedList mockedList;

		//using mock
		mockedList.add("once");

		mockedList.add("twice");
		mockedList.add("twice");

		mockedList.add("three times");
		mockedList.add("three times");
		mockedList.add("three times");

		//mockedList.add("five times");

		//following two verifications work exactly the same - times(1) is used by default
		verify(mockedList).add("once");
		verify(mockedList, times(1)).add("once");

		//exact number of invocations verification
		verify(mockedList, times(2)).add("twice");
		verify(mockedList, times(3)).add("three times");

		//verification using never(). never() is an alias to times(0)
		verify(mockedList, never()).add("never happened");

		//verification using atLeast()/atMost()
		verify(mockedList, atLeastOnce()).add("three times");
		verify(mockedList, atLeast(1)).add("five times");
		verify(mockedList, atMost(5)).add("three times");

		// verify(mockedList, atLeast(2)).add("fivexx times");

	}

	//When clause Demo
	@Test
	public void testWhenCondition(){
		LinkedList mockedList = mock(LinkedList.class);
		when(mockedList.getLast()).thenReturn("Sorry can't get it");

		System.out.println(mockedList.getLast());
	}

	//doReturn()|doThrow()| doAnswer()|doNothing()|doCallRealMethod() family of methods
	@Test
	public void testDoThrowFamily(){
		LinkedList mockedList = mock(LinkedList.class);

		doThrow(new RuntimeException()).when(mockedList).clear();   //RSN NOTE special attention to the syntex here

		//following will throw runtime exception
		mockedList.clear();

	}


	public static void main(String[] args) {

		//Note YOU DON"T NEED MAIN to execute unit tests
	}
}
