package com.Train1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class CollectionEmployeeOperationsUtil {

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

	public static void insertEmployee(IEmployeeArrayOpertions empInterf) {
		Employee empl = readEmployee();
		try {
			empInterf.insertEmployee(empl);
		} catch (InvalidSalaryException e) {
			e.printStackTrace();
		}

	}

	public static void findEmployeebyID(IEmployeeArrayOpertions empInterf, int id) {
		Employee emp = empInterf.findEmployee(id);
		System.out.println(emp);
	}

	public static void findEmployeebyName(IEmployeeArrayOpertions empInterf, String name) {
		Employee emp2 = empInterf.findEmployee(name);
		System.out.println(emp2);
	}

	public static void deleteEmployee(IEmployeeArrayOpertions empInterf, int id) {

		try {
			empInterf.deleteEmployee(id);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void updateEmployee(IEmployeeArrayOpertions empInterf) {
		Employee empl = readEmployee();

		try {
			empInterf.updateEmployee(empl);
		} catch (InvalidSalaryException e) {
			e.printStackTrace();
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void calculateGrossSalary(IEmployeeArrayOpertions empInterf, int id) {
		empInterf.calculateGrossSal(id);
	}

	public static void sortbyAgeSalary(IEmployeeArrayOpertions empInterf) {
		List<Employee> empList = ((CollectionEmployeeOperations) empInterf).sortbyAgeSalary();
		for (Employee e : empList) {
			System.out.println(e);
		}
	}

	public static void sortByName(IEmployeeArrayOpertions empInterf) {
		List<Employee> empList = ((CollectionEmployeeOperations) empInterf).sortbyName();
		for (Employee e : empList) {
			System.out.println(e);
		}
	}

	public static void uniqueNames(IEmployeeArrayOpertions empInterf) {
		Set<String> set = ((CollectionEmployeeOperations) empInterf).uniqueEmployeeNames();
		for (String s : set) {
			System.out.println(s);
		}
	}

	public static void ageRange(IEmployeeArrayOpertions empInterf) {
		HashMap<String, Integer> map = ((CollectionEmployeeOperations) empInterf).ageRangeCounter();
		for (Map.Entry<String, Integer> entry : map.entrySet())
			System.out.println("AgeRange: " + entry.getKey() + ", count = " + entry.getValue());
	}

	public static void populateDatafromExcel(IEmployeeArrayOpertions empInterf) {
		List<Employee> empList = CSVListReader.readEmployees();
		for (int i = 0; i < empList.size(); i++) {
			if (empList.get(i) != null) {
				empInterf.insertEmployee(empList.get(i));
			}
		}
	}

	public static void populateDatatoExcel(IEmployeeArrayOpertions empInterf) {
		CSVListWriter.writeEmployees((CollectionEmployeeOperations) empInterf);
	}

	public static void menu() {
		System.out.println("Press 0. for Display of an Employee");
		System.out.println("Press 1. for Insert an Employee");
		System.out.println("Press 2. for findEmployee by EmployeeID");
		System.out.println("Press 3. for findEmployee by EmployeeName");
		System.out.println("Press 4. for Delete Employee by EmployeeID");
		System.out.println("Press 5. for Update Employee by EmployeeID");
		System.out.println("Press 6. for calculate Gross Salary of an Employee");
		System.out.println("Press 7. for Sorted Age-Salary List  of Employees");
		System.out.println("Press 8. for Sorted Names List  of Employees");
		System.out.println("Press 9. for Unique Names List of Employees");
		System.out.println("Press 10. for Age Range Count of Employees");
		System.out.println("Press 11. for exit");
	}
}
