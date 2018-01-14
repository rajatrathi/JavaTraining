package com.genricEmp;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("hiding")
public class GenericEmployeeServiceImpl<E> implements IGenericEmployeeService<E> {
	List<E> eList = new ArrayList<>();

	@Override
	public void insertEmployee(E e) {
		eList.add(e);
	}

	@Override
	public E findEmployee(E e) {
		for (E e1 : eList) {
			if (e1.equals(e)) {
				return e;
			}
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(E e) {
		for (E e1 : eList) {
			if (e1.equals(e)) {
				eList.remove(e);
			}
		}
		return false;
	}
                     
	@Override
	public boolean updateEmployee(E e) {
		for (int i = 0; i < eList.size(); i++) {
			E e1 = eList.get(i);
			if (e1.equals(e)) {
				eList.set(i, e);
			}
		}
		return false;
	}
	
	public void display() {
		for (E e1 : eList) {
			System.out.println(e1);
		}
	}
}
