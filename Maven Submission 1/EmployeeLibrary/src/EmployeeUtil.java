package com.Train1;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class EmployeeUtil 
{
	public static void displayEmployerInfofromUtil(Employee emp) {
		System.out.println(emp.getEmpNo());
		System.out.println(emp.getName());
		System.out.println(emp.getSalary());
		System.out.println(emp.getDoj());
		System.out.println(emp.getHRA());
	}
	
	public  static Employee compareEmployeeSalary(Employee emp1,Employee emp2) {
		return emp1.getSalary() > emp2.getSalary() ? emp1 : emp2;
	}
	
	public  static Employee constructEmpfromEmp(Employee emp1) 
	{
		Employee emp2 = new Employee();
		emp2= emp1;
		return emp2;
	}
	
	public static Date getDate(int year, int month,int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year+1);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, day);	
		return calendar.getTime();
	}
	
	public static void getOlder(Employee e1, Employee e2)
	{
		 if(e1.getAge()-e2.getAge()>0)
         {
        	 System.out.println("Older Employee is:"+e1.getName());
         }
      else
         {
	         System.out.println("Older Employee is:"+e2.getName());
        }
	
	}
	
	public static void salaryIncrement(Employee emp)
	{
	if(emp.getSalary()<10000  && emp.getAge()>35 && emp.getAge()<45)
	{
	emp.setSalary(emp.getSalary()*1.15f);	
	}
	else if(emp.getSalary()>10000 && emp.getSalary()<15000  && emp.getAge()>45 && emp.getAge()<55)
	{
	emp.setSalary(emp.getSalary()*1.2f);	
	}
	else if(emp.getSalary()>15000 && emp.getSalary()<20000 && emp.getAge()>55)
	{
	emp.setSalary(emp.getSalary()*1.25f);	
	}
	}
	
	public static void salaryDist(Employee emp)
	{
		float da=0;
		float hra=0;
		if(emp.getSalary()<10000)
		{
			da =  emp.getSalary()*0.08f;
			hra =  emp.getSalary()*0.15f;
			displayDAandHRA(da,hra,emp);
			displayGrossSalary(da,hra,emp);
		}
		else if(emp.getSalary()>10000 && emp.getSalary()<20000)
		{
			da =  emp.getSalary()*0.1f;
			hra =  emp.getSalary()*0.2f;
			displayDAandHRA(da,hra,emp);
			displayGrossSalary(da,hra,emp);
		}
		else if(emp.getSalary()>20000 && emp.getSalary()<30000 && emp.getAge()>=40)
		{
			da =  emp.getSalary()*0.15f;
			hra =  emp.getSalary()*0.27f;
			displayDAandHRA(da,hra,emp);
			displayGrossSalary(da,hra,emp);
		}
		else if(emp.getSalary()>20000 && emp.getSalary()<30000 && emp.getAge()<40)
		{
			da =  emp.getSalary()*0.13f;
			hra =  emp.getSalary()*0.25f;
			displayDAandHRA(da,hra,emp);
			displayGrossSalary(da,hra,emp);
		}
		else
		{
			da =  emp.getSalary()*0.17f;
			hra =  emp.getSalary()*0.3f;
			displayDAandHRA(da,hra,emp);
			displayGrossSalary(da,hra,emp);
		}
		
	}
	
	
	public static void salaryDist1(Employee emp)
	{
		float da=0;
		float hra=0;
		if(emp.getSalary()<10000)
		{
			da =  emp.getSalary()*0.08f;
			hra =  emp.getSalary()*0.15f;
			displayGrossSalary(da,hra,emp);
		}
		else if(emp.getSalary()>10000 && emp.getSalary()<20000)
		{
			da =  emp.getSalary()*0.1f;
			hra =  emp.getSalary()*0.2f;
			displayGrossSalary(da,hra,emp);
		}
		else if(emp.getSalary()>20000 && emp.getSalary()<30000 && emp.getAge()>=40)
		{
			da =  emp.getSalary()*0.15f;
			hra =  emp.getSalary()*0.27f;
			displayGrossSalary(da,hra,emp);
		}
		else if(emp.getSalary()>20000 && emp.getSalary()<30000 && emp.getAge()<40)
		{
			da =  emp.getSalary()*0.13f;
			hra =  emp.getSalary()*0.25f;
			displayGrossSalary(da,hra,emp);
		}
		else
		{
			da =  emp.getSalary()*0.17f;
			hra =  emp.getSalary()*0.3f;
			displayGrossSalary(da,hra,emp);
		}
		
	}
	
	
	public static Double salaryDist2(Employee emp)
	{
		float da=0;
		float hra=0;
		double grossSalary=0;
		if(emp.getSalary()<10000)
		{
			da =  emp.getSalary()*0.08f;
			hra =  emp.getSalary()*0.15f;
			grossSalary	=	displayGrossSalary1(da,hra,emp);
		}
		else if(emp.getSalary()>10000 && emp.getSalary()<20000)
		{
			da =  emp.getSalary()*0.1f;
			hra =  emp.getSalary()*0.2f;
			grossSalary=displayGrossSalary1(da,hra,emp);
		}
		else if(emp.getSalary()>20000 && emp.getSalary()<30000 && emp.getAge()>=40)
		{
			da =  emp.getSalary()*0.15f;
			hra =  emp.getSalary()*0.27f;
			grossSalary = displayGrossSalary1(da,hra,emp);
		}
		else if(emp.getSalary()>20000 && emp.getSalary()<30000 && emp.getAge()<40)
		{
			da =  emp.getSalary()*0.13f;
			hra =  emp.getSalary()*0.25f;
			grossSalary= displayGrossSalary1(da,hra,emp);
		}
		else
		{
			da =  emp.getSalary()*0.17f;
			hra =  emp.getSalary()*0.3f;
			grossSalary= displayGrossSalary1(da,hra,emp);
		}
		return grossSalary;
		
	}
	static void displayDAandHRA(float da,float hra, Employee e)
	{
		System.out.println("DA of "+e.getName()+" is:"+da);
		System.out.println("HRA of "+e.getName()+" is:"+hra);
		
	}
	static void displayGrossSalary(float da,float hra, Employee e)
	{
		float grossSalary = da+hra+e.getSalary();
        System.out.println("Gross Salary of "+e.getName()+" is:"+grossSalary);
	}
	
	
	static double displayGrossSalary1(float da,float hra, Employee e)
	{
		double grossSalary = da+hra+e.getSalary();
        System.out.println("Gross Salary of "+e.getName()+" is:"+grossSalary);
        return grossSalary;
	}
	
	
	
}
