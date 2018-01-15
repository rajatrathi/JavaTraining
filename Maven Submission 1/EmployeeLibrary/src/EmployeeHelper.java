package com.Train1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EmployeeHelper 

{
	Employee emp = null;
	
	public EmployeeHelper(Employee emp) {
		this.emp = emp;
	}
	
	public void SalaryIncerment() 
	{
	float newSalary;
	newSalary = (float) (1.20*(float)emp.getSalary());
	emp.setSalary(newSalary);
	System.out.println("New Salary of Employee"+newSalary);
	}
	
	public void getSenior(Employee e1, Employee e2)
	{
		if(e1.getDoj().compareTo(e2.getDoj())<0)
         {
        	 System.out.println("Senior Employee is:"+e1.getName());
         }
      else
         {
	         System.out.println("Senior Employee is:"+e2.getName());
        }
	
	}
	
	public void getServiceDuration(Employee e)
	{	
		try {
			Date d1 = e.getDoj();
			Date d2 = new Date();
			long diffDays = (d2.getTime() - d1.getTime())/((24 * 60 * 60 * 1000));
			long diffyear = diffDays/365;
			long diffmonths = diffDays%12;
			long diffdays = diffDays%30;
			System.out.println("Service of "+e.getName()+" is:"+
			diffyear + " years, "+diffmonths + " months, "+ diffdays + " days.");		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}
