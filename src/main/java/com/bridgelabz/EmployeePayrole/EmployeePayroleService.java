package com.bridgelabz.EmployeePayrole;

	import java.util.List;
	import java.util.Scanner;
	import java.util.ArrayList;

	public class EmployeePayroleService {
		public enum IOService {
			CONSOLE_IO, FILE_IO, DB_IO, REST_IO
		}
		private List<EmployeePayroleData> employeePayrollList;
		public EmployeePayroleService() {
		}
		public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
			this.employeePayroleList = employeePayrollList;
		}
		private void readEmployeePayroleData(Scanner consoleInputReader) {
			System.out.println("Enter the Employee Id : ");
			int id = consoleInputReader.nextInt();
			System.out.println("Enter the Employee Name : ");
			String name = consoleInputReader.next();
			System.out.println("Enter the Employee Salary : ");
			double salary = consoleInputReader.nextDouble();
			employeePayroleList.add(new EmployeePayroleData(id, name, salary));
		}
		public void writeEmployeePayroleData(IOService ioService) {
			if(ioService.equals(IOService.CONSOLE_IO))
				System.out.println("\nWriting Employee Payroll  to Console\n" + employeePayrollList);
			
			else if(ioService.equals(IOService.FILE_IO))
				new EmployeePayroleFileIOService().writeData(employeePayrollList);
		}
		
		public void printData(IOService fileIo) {
			if(fileIo.equals(IOService.FILE_IO)) new EmployeePayroleFileIOService().printData();
		}


		public long countEntries(IOService fileIo) {
			if(fileIo.equals(IOService.FILE_IO)) 
				return new EmployeePayroleFileIOService().countEntries();
			
			return 0;
		}
		public long readDataFromFile(IOService fileIo) {
			List<String> employeePayrollFromFile = new ArrayList<String>();
			if(fileIo.equals(IOService.FILE_IO)) {
				System.out.println("Employee Details from payroll-file.txt");
				employeePayrollFromFile = new EmployeePayroleFileIOService().readDataFromFile();
			}
			return EmployeePayroleFromFile.size();
		}
		public static void main(String[] args) {
			System.out.println("Welcome To Employee Payroll Application");
			ArrayList<EmployeePayroleData> employeePayrollList  = new ArrayList<EmployeePayroleData>();
			EmployeePayrollService employeePayrollService = new EmployeePayroleService(employeePayroleList);
			Scanner consoleInputReader = new Scanner(System.in);
			
			employeePayrollService.readEmployeePayrollData(consoleInputReader);
			employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);		
		}
	}

