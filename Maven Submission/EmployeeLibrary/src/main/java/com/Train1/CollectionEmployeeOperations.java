package com.Train1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionEmployeeOperations implements IEmployeeArrayOpertions {

	List<Employee> empArray = new ArrayList<Employee>();

	public CollectionEmployeeOperations() {
		// TODO Auto-generated constructor stub
	}

	public void insertEmployee(Employee employee) throws InvalidSalaryException {

		if (employee.getSalary() < 5000) {
			throw new InvalidSalaryException("Invalid Salary Entered by User !");
		} else {
			empArray.add(employee);
		}
	}

	public Employee findEmployee(int empId) {
		for (Employee e1 : empArray) {
			if (empId == e1.getEmployeeId()) {
				return e1;
			}
		}
		return null;
	}

	public Employee findEmployee(String name) {
		for (Employee e1 : empArray) {
			if (name.equals(e1.getName()) && e1.getName() != null) {

				return e1;
			}
		}
		return null;
	}

	public boolean deleteEmployee(int empId) throws EmployeeNotFoundException {

		boolean flag = false;
		for (int i = 0; i < empArray.size(); i++) {
			if (empArray.get(i) != null)
				if (empId == empArray.get(i).getEmployeeId()) {
					flag = true;
					empArray.remove(i);
				}
		}

		if (flag == false) {
			throw new EmployeeNotFoundException("Employee ID does not exist !");
		}
		return true;
	}

	public boolean updateEmployee(Employee employee) throws EmployeeNotFoundException {
		boolean flag = false;
		for (Employee e1 : empArray) {
			if (employee.getEmployeeId() == e1.getEmployeeId()) {
				flag = true;
				e1.setEmployeeId(employee.getEmployeeId());
				e1.setEmpNo(employee.getEmpNo());
				e1.setName(employee.getName());
				e1.setSalary(employee.getSalary());
				e1.setDoj(employee.getDoj());
				e1.setAge(employee.getAge());
				return true;
			}
		}
		if (flag == false) {
			throw new EmployeeNotFoundException("Employee ID does not exist !");
		}
		return false;
	}

	public Double calculateGrossSal(int empId) {
		for (Employee e1 : empArray) {
			if (e1.getEmployeeId() == empId) {
				{
					double grossSalary = EmployeeUtil.salaryDist2(e1);
					return grossSalary;
				}
			}
		}
		return null;
	}

	public List<Employee> sortbyAgeSalary() {
		Collections.sort(empArray);
		return empArray;
	}

	public List<Employee> sortbyName() {
		Collections.sort(empArray, new Employee.SortbyEmployeeName());
		return empArray;
	}

	public Set<String> uniqueEmployeeNames() {
		Set<String> uniqueNames = new HashSet<String>();
		for (Employee e : empArray) {
			uniqueNames.add(e.getName());
		}
		return uniqueNames;
	}

	public HashMap<String, Integer> ageRangeCounter() {
		Map<String, Integer> AgeRangeMap = new HashMap<String, Integer>();
		AgeRangeMap.put("Employee in Age Range from 20-30 are", 0);
		AgeRangeMap.put("Employee in Age Range from 30-40 are", 0);
		AgeRangeMap.put("Employee in Age Range from 40-50 are", 0);
		AgeRangeMap.put("Employee in Age Range from 50-60 are", 0);
		for (Employee e : empArray) {
			if (e.getAge() >= 20 && e.getAge() < 30) {
				if (AgeRangeMap.containsKey("Employee in Age Range from 20-30 are")) {
					int count = AgeRangeMap.get("Employee in Age Range from 20-30 are");
					AgeRangeMap.put("Employee in Age Range from 20-30 are", count + 1);
				} else {
					AgeRangeMap.put("Employee in Age Range from 20-30 are", 1);
				}
			}
			else if (e.getAge() >= 30 && e.getAge() < 40) {
				if (AgeRangeMap.containsKey("Employee in Age Range from 30-40 are")) {
					int count = AgeRangeMap.get("Employee in Age Range from 30-40 are");
					AgeRangeMap.put("Employee in Age Range from 30-40 are", count + 1);
				} else {
					AgeRangeMap.put("Employee in Age Range from 30-40 are", 1);
				}
			}
			else if (e.getAge() >= 40 && e.getAge() < 50) {
				if (AgeRangeMap.containsKey("Employee in Age Range from 40-50 are")) {
					int count = AgeRangeMap.get("Employee in Age Range from 40-50 are");
					AgeRangeMap.put("Employee in Age Range from 40-50 are", count + 1);
				} else {
					AgeRangeMap.put("Employee in Age Range from 40-50 are", 1);
				}
			}
			else if (e.getAge() >= 50 && e.getAge() < 60) {
				if (AgeRangeMap.containsKey("Employee in Age Range from 50-60 are")) {
					int count = AgeRangeMap.get("Employee in Age Range from 50-60 are");
					AgeRangeMap.put("Employee in Age Range from 50-60 are", count + 1);
				} else {
					AgeRangeMap.put("Employee in Age Range from 50-60 are", 1);
				}
			}
		}
		return (HashMap<String, Integer>) AgeRangeMap;
	}
	public void display() {
		for (Employee e : empArray) {
			System.out.println(e);

		}
	}

}
