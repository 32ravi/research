package rjunit;

import org.junit.Test;

/*
 * http://www.mkyong.com/unittest/junit-4-tutorial-4-time-test/
 * This timeout example only applies to a single test method. And the timeout value is in milliseconds.
 */

public class TimeoutTest {

    //This test will always failed :)
    @Test(timeout = 1000)
    public void infinity() {
        while (true) ;
    }

    //This test can't run more than 5 seconds, else failed
    @Test(timeout = 5000)
    public void testSlowMethod() {
        //...
    }

}