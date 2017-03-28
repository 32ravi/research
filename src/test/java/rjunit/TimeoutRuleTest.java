package rjunit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

/*
 * his example shows you how to create a global timeout rule, this rule will apply to all the test methods in a class.
 * 
 * In the above example, a global Timeout rule is declared, both the testSlowMethod1() and testSlowMethod2() must finish the test within 1 second, else the test will be failed.

P.S The rule also applies on @Before and @After methods.

Note
All unit test should be fast, and this global timeout rule should be your best helper.
 */


public class TimeoutRuleTest {

    //RSN NOTE global rule
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1);

	//This test will be failed, because it will take more than 1 second to finish!
    @Test
    public void testSlowMethod1() throws InterruptedException {
        //...
        TimeUnit.SECONDS.sleep(5000);
    }

	//passed
    @Test
    public void testSlowMethod2() {
        //...
    }

}