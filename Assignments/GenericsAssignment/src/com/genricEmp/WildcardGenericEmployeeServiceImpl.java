package com.genricEmp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("rawtypes")
public class WildcardGenericEmployeeServiceImpl<E extends Employee> implements IWildcardGenericEmployeeService
{
	List<E> eList = new ArrayList<>();

	@Override
	public void insertEmployee(Employee e) {
		eList.add((E) e);
		
	}

	@Override
	public Employee findEmployee(Employee e) {
		for (E e1 : eList) {
			if (e1.equals((E)e)) {
				return (E)e;
			}
		}
		return null;

	}

	@Override
	public boolean deleteEmployee(Employee e) {
		for (E e1 : eList) {
			if (e1.equals((E)e)) {
				eList.remove((E)e);
			}
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		for (E e1 : eList) {
			if (e1.getEmployeeId()== e.getEmployeeId()) {
				
				e1.setEmployeeId(e.getEmployeeId());
				e1.setEmpNo(e.getEmpNo());
				e1.setName(e.getName());
				e1.setSalary(e.getSalary());
				e1.setDoj(e.getDoj());
				e1.setAge(e.getAge());;
			}
		}
	return false;
	}
	
	public void displayEmployees() {
		for (E e1 : eList) {
			System.out.println(e1);
		}
	}
}
