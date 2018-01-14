package com.genricEmp;

import java.sql.SQLException;
import java.util.Scanner;

public class GenericEmployeeServiceUtil {

	public static Employee readEmployee() {
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();
		sc = new Scanner(System.in);
		System.out.println("Enter employeeID for Employee");
		int empID = sc.nextInt();
		System.out.println("Enter employeeNo for Employee");
		int empNo = sc.nextInt();
		System.out.println("Enter name for Employee");
		String name = sc.next();
		System.out.println("Enter salary for Employee");
		float salary = sc.nextFloat();
		System.out.println("Enter Year of joining for Employee");
		int year = sc.nextInt();
		System.out.println("Enter Month of joining for Employee");
		int month = sc.nextInt();
		System.out.println("Enter Date of joining for Employee");
		int date = sc.nextInt();
		System.out.println("Enter age for Employee");
		int age = sc.nextInt();
		emp = emp.constructEmployeewithEmpID(empID, empNo, name, salary, EmployeeUtil.getDate(year, month, date), age);
		return emp;
	}

	public static void insertEmployee(IGenericEmployeeService empInterf) throws SQLException {
		Employee empl = readEmployee();
			empInterf.insertEmployee(empl);
	}

	public static void findEmployee(IGenericEmployeeService empInterf) throws SQLException {
		System.out.println("Enter Id of user which you want to search:");
		//Scanner sc12 = new Scanner(System.in);
		//int id = sc12.nextInt();
		//Employee emp = empInterf.findEmployee(emp);
		Employee empl = readEmployee();
		empInterf.findEmployee(empl);
		System.out.println(empl);
	}

	

	public static void deleteEmployee(IGenericEmployeeService empInterf) throws SQLException {
		System.out.println("Enter Id of user which you want to delete:");
		//Scanner sc11 = new Scanner(System.in);
		//int id = sc11.nextInt();
		Employee empl = readEmployee();
	//	empInterf.findEmployee(empl);
			empInterf.deleteEmployee(empl);
	
	}

	public static void updateEmployee(IGenericEmployeeService empInterf) throws SQLException {
		System.out.println("Enter Id of user which you want to update:");
		Employee empl = readEmployee();
		empInterf.updateEmployee(empl);
		
	}
	
	public static void menu() {
		System.out.println("Press 0. for Display all Employees");
		System.out.println("Press 1. for Insert an Employee");
		System.out.println("Press 2. for FindEmployee by EmployeeDetails");
		System.out.println("Press 4. for Delete Employee by EmployeeDetails");
		System.out.println("Press 5. for Update Employee by EmployeeDetails");
		System.out.println("Press 6. for exit");
	}
}
