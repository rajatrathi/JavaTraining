package com.Train1;
import java.util.Comparator;
import java.util.Date;



public class Employee implements Comparable<Employee>{
	private int employeeId;

	private int empNo;
	private String name;
	private float salary;
	private Date doj;
    private static String COMPANY_NAME;
	int age;
    
	{
		salary = 10000;	
	}
	
    static
    {
    	COMPANY_NAME = "XYZ Comp";
    }
    
    static String getCompanyName()
    {
    	return COMPANY_NAME;
    }
    
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	@Override
	public String toString() {
		return "Employee [+employeeId=" + employeeId +",empNo=" + empNo + ", name=" + name + ", salary=" + salary + ", doj=" + doj + ", age=" + age + "]";
	}
	//
	
	public  Employee constructEmployee(int empNo, String name, float salary, Date doj) {
		Employee emp = new Employee();
		emp.setEmpNo(empNo);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setDoj(doj);
		return emp;
	}
	public  Employee constructEmployeewithAge(int empNo, String name, float salary, Date doj,int age) {
		Employee emp = new Employee();
		emp.setEmpNo(empNo);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setDoj(doj);
		emp.setAge(age);
		return emp;
	}
	
	public  Employee constructEmployeewithEmpID(int employeeId,int empNo, String name, float salary, Date doj,int age) {
		Employee emp = new Employee();
		emp.setEmployeeId(employeeId);
		emp.setEmpNo(empNo);
		emp.setName(name);
		emp.setSalary(salary);
		emp.setDoj(doj);
		emp.setAge(age);
		return emp;
	}
	
	public float getHRA() {
		return (float)(salary*0.2);
	}
	
	public static void displayEmployerInfo(Employee emp) {
		System.out.println(emp);
		System.out.println(emp.getHRA());
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	static class SortbyEmployeeName implements Comparator<Employee>
	{
	    public int compare(Employee a, Employee b)
	    {
	        return (int) (a.name.compareTo(b.name));
	    }
	}
	public int compareTo(Employee o) {
		final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    if (this.age < o.age) return BEFORE;
	    if (this.age > o.age) return AFTER;
	    if (this.salary < o.salary) return BEFORE;
	    if (this.salary > o.salary) return AFTER;
	    return EQUAL;	
	}


}
