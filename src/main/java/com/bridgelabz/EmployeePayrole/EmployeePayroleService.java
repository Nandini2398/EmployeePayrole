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

	public EmployeePayroleService(List<EmployeePayroleData> employeePayroleList) {
		this.employeePayroleList = employeePayroleList;
	}
	private void readEmployeePayroleData(Scanner consoleInputReader) {
		System.out.println("Enter the Employee Id : ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter the Employee Name : ");
		String name = consoleInputReader.next();
		System.out.println("Enter the Employee Salary : ");
		double salary = consoleInputReader.nextDouble();
		
		employeePayrollList.add(new EmployeePayroleData(id, name, salary));
	}
	private void writeEmployeePayroleData() {
		System.out.println("\nWriting Employee Payroll Roster to Console\n" + employeePayroleList);
	}
	public static void main(String[] args) {
		System.out.println("---------- Welcome To Employee Payroll Application ----------\n");
		ArrayList<EmployeePayroleData> employeePayrollList  = new ArrayList<EmployeePayroleData>();
		EmployeePayroleService employeePayrollService = new EmployeePayroleService(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);
		employeePayrollService.readEmployeePayroleData(consoleInputReader);
		employeePayrollService.writeEmployeePayroleData();
	}
}