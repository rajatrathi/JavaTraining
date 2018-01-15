package com.Train1;

import java.util.List;

public interface IEmployeeArrayOpertions

{
	void insertEmployee(Employee employee) throws InvalidSalaryException;
	Employee findEmployee(int empId);
	Employee findEmployee(String name);
	boolean deleteEmployee(int empId) throws EmployeeNotFoundException;
	boolean updateEmployee(Employee employee) throws EmployeeNotFoundException;
	Double calculateGrossSal(int empId);
}
