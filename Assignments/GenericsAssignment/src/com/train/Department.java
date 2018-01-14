package com.train;
import lombok.Data;

@Data
public class Department 
{
int	deptNo ;
String deptName;
String location;

@Override
public String toString() {
	return "Department [deptNo=" + deptNo + ", deptName=" + deptName + ", location=" + location + "]";
}


public static void main(String[] args)
{
	Department dept = new Department();
	dept.setDeptName("Maths");
	dept.setDeptNo(101);
	dept.setLocation("Los Angeles");
	System.out.println(dept); 
}
}

