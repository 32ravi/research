package rjunitPowerMock;

import static org.easymock.EasyMock.expect;
import static org.powermock.api.easymock.PowerMock.expectNew;
import static org.powermock.api.easymock.PowerMock.replay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import rjunitPowerMock.ConstructorExample;
import rjunitPowerMock.SimpleClass;

import static org.powermock.api.easymock.PowerMock.verify;
import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ConstructorExample.class)
public class ConstructorExampleTest_PowerNEasyMock {
	
	@Mock private SimpleClass mockSimpleClass;
	
	private ConstructorExample instance;
	
	@Test
	public void testMockConstructor() throws Exception {
		instance = new ConstructorExample();
		expectNew(SimpleClass.class).andReturn(mockSimpleClass);
		
		expect(mockSimpleClass.getMeCurrentDateAsString()).andReturn("Mock Result");
		
		replay(SimpleClass.class, mockSimpleClass);
		String value = instance.getMeSimpleObject();
		verify(SimpleClass.class, mockSimpleClass);
		assertEquals("Mock Result", value);		
	}

}
