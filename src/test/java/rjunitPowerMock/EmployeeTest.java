package rjunitPowerMock;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import junit.framework.Assert;
import rjunitPowerMock.EmployeeController;
import rjunitPowerMock.EmployeeService;

@SuppressWarnings("deprecation")
public class EmployeeTest {
	
	@Test
	public void shouldGetCountOfEmployees()
	{
		EmployeeController employeeController =new EmployeeController(new EmployeeService());
		Assert.assertEquals(10,employeeController.getProjectedEmployeeCount());

	}

	@Test
	public void firstMockTest() 
	{
		//Creating a mock using the PowerMockito.mock
		//method for the EmployeeService class.
		EmployeeService mock =PowerMockito.mock(EmployeeService.class);

		//Next statement essentially says that when getProjectedEmployeeCount method
		//is called on the mocked EmployeeService instance, return 8.
		PowerMockito.when(mock.getEmployeeCount()).thenReturn(8);

		EmployeeController employeeController = new EmployeeController(mock);

		Assert.assertEquals(16, employeeController.getProjectedEmployeeCount());
	}

}
