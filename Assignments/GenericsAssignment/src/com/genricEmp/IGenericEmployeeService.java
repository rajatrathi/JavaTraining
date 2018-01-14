package com.genricEmp;

public interface IGenericEmployeeService<E>
{
	public  void insertEmployee(E e); 
	E findEmployee(E e);
	boolean deleteEmployee(E e);
	boolean updateEmployee(E e);
}
