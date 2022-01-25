package com.bridgelabz.EmployeePayrole;

	import java.util.Arrays;
	import org.junit.Assert;
	import org.junit.Test;
	import com.bridgelabz.employeepayrole.EmployeePayroleService.IOService;

	public class EmployeePayroleServiceTest 
	{
		@Test
		public void given3Employees_WhenWrittenToFile_ShouldMatchEmployeeEntries()
		{
			EmployeePayroleData[] arrayOfEmployees = {
					new EmployeePayroleData(1, "Jeff Bezos", 100000.0),
					new EmployeePayroleData(2, "Bill Gates", 200000.0),
					new EmployeePayroleData(3, "Mark Zuckerberg", 300000.0)};
			EmployeePayroleService employeePayrollService;
			employeePayrollService = new EmployeePayroleService(Arrays.asList(arrayOfEmployees));
			employeePayrollService.writeEmployeePayroleData(IOService.FILE_IO);
			
			employeePayrollService.printData(IOService.FILE_IO);
			long entries = employeePayrollService.countEntries(IOService.FILE_IO);
			Assert.assertEquals(3, entries);
		}
		@Test
		public void givenFile_WhenRead_ShouldReturnNumberOfEntries() {
			EmployeePayroleService employeePayrollService = new EmployeePayroleService();
			long entries = employeePayrollService.readDataFromFile(IOService.FILE_IO);
			Assert.assertEquals(3, entries);
		}
		
	}
}
