package com.genricEmp;

public interface IWildcardGenericEmployeeService <E extends Employee> 
{
	public  void insertEmployee(E e); 
	public E findEmployee(E e);
	public boolean deleteEmployee(E e);
	public boolean updateEmployee(E e);
	public void displayEmployees();
}
