package rjunitPowerMock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
//import org.powermock.modules.testng.PowerMockTestCase;
import org.powermock.reflect.Whitebox;

import rjunitPowerMock.Human;
import rjunitPowerMock.Puppy;

import static org.mockito.Mockito.times;

/*
 * http://www.johnmullins.co/blog/2015/02/15/beginners-guide-to-using-mockito-and-powermockito-to-unit-test-java/
 * 
 * Mocking is something we do to classes to make our life simplier while unit testing. 
 * Essentially, it turns off all the functionality of a class.
 *  This is useful when we want to test methods that call functionality on other objects.
 */

@PrepareForTest({Puppy.class})
@RunWith(PowerMockRunner.class)
//public class RSN_PuppyTest_PowerMock extends PowerMockTestCase {
public class RSN_PuppyTest_PowerMock {

	/* we use Mockito to mock a human class. This prevents all of Human’s methods from doing anything,
	 *  but more specifically prevents isSoHappy() from being called in Puppy.createPuppy().
   Notice that we also use Mockito.verify() to verify the method was still called only once even though it does not actually do anything.
   RSN If you don't use Human Mock and instead use real Human object, then you can't call verify isSoHappy()
	 */
    @Test
    public void testCreatePuppy() throws Exception {
        //Mocking
        Human human = Mockito.mock(Human.class);
    	//Human human = new Human("humanA"); // try using this human object instead.
        Puppy puppy = Puppy.createPuppy("Gatsby", human);
        assert(puppy != null);
        assert(puppy.getName().equals("Gatsby"));
        //Verifying
       Mockito.verify(human, times(1)).isSoHappy(); //RSN IMP If real human obj is used, then You can't call this verify

    }

 /*RSN SPYING - Lets suppose we want a class to do everything it would normally do EXCEPT for one or more specific methods.
 This is where spying and PowerMockito comes into place. 
 We can spy on an object and specify when methods are called to do other things.
 */
 
    @Test
    public void testChaseTail() throws Exception {
        Human human = Mockito.mock(Human.class);
        //Spying
        Puppy puppy = PowerMockito.spy(new Puppy("Gatsby", human)); //RSN NOTE Mockito.spy won't work here, try it.
        //Puppy puppy = Mockito.spy(new Puppy("Gatsby", human)); 
       
        Mockito.doNothing().when(puppy).bark();
      
        puppy.chaseTail();
        Mockito.verify(puppy, times(1)).bark();
        Mockito.verify(puppy, times(0)).performPuppyTasks();
    }

    /*Learn Spying on PRIVATE methods....PowerMock!!!
     * Lets suppose we want to spy on an object but we want a private method to do something else. PowerMockito has you covered!
     * 
     * Notice how we are mixing Mockito with PowerMockito. 
     * Not only can we do this, it is encouraged. PowerMockito is a permgen memory hog and creates tons of classes. 
     * RSN IMP ------>Whenever we can use Mockito over PowerMockito, we should!
     */
  @Test
    public void testGoOnWalk() throws Exception {
        Human human = Mockito.mock(Human.class);
        //Power Spying
        Puppy puppy = PowerMockito.spy(new Puppy("Gatsby", human));
      
        PowerMockito.doNothing().when(puppy, "performBusiness"); //performBusiness is a private method
        //Can combine regular and power
        Mockito.doNothing().when(puppy).wipeOffFeet();
      
        puppy.goOnWalk(15);
        Mockito.verify(puppy, times(1)).wipeOffFeet();
        Mockito.verify(puppy, times(0)).performPuppyTasks();
    }

  
  
  /*LEARN Static Methods stubbing
   * Lets suppose you have a class with a static method and we want to stub out its behaviour. PowerMockito has a way to do this.
   * 
   * We specify PowerMockito.mockStatic on the class we want to stub our static method.
   *  later(PowerMockito.when(Puppy....) we stub it out like any other method.
   */
    @Test
    public void testBuyPuppy() throws Exception {
        //Mocking static
        PowerMockito.mockStatic(Puppy.class); //If you don't do this line, u can't change behavior of createPuppy below...
        Human human = new Human("John");  //NOTE this is real human object not mock. This time Puppy will be mocked.
        Puppy puppy = Mockito.mock(Puppy.class);
        
        //Static mocking and matchers
        //we are specifying that we need the first arguement to be “Gatsby” but we will accept any Human.class for the second arguement.
        PowerMockito.when(Puppy.createPuppy(Mockito.eq("Gatsby"), Mockito.any(Human.class))).thenReturn(puppy); // U must do .mockStatic above, to achive stubbing createPuppy
        human.buyPuppy("Gatsby");
        assert(human.puppy != null);
        System.out.println("Mock object's Static method behaviour changed/stubbed!!!");
    }

    /* LEARN Whitebox - acces private member or invoke private methods, PowerMock !!!
     * 
     * If you need to access any private members or invoke private methods we can use WhiteBox which is provided with PowerMockito.
     */
    @Test
    public void testEat() throws Exception {
        Human human = Mockito.mock(Human.class);
        Puppy puppy = PowerMockito.spy(new Puppy("Gatsby",human));
      
        //Get private variables
        int energy = Whitebox.getInternalState(puppy, "energyLevel");
     
        //Call private methods
        Whitebox.invokeMethod(puppy, "eat");
       
        int energyAfterwards = Whitebox.getInternalState(puppy, "energyLevel");
        System.out.println("Accessed Private variable, energyLabel : " + energyAfterwards + " > " + energy);
        assert(energy <= energyAfterwards);
    }
}