package com.Train1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVListReader {

	public static List<Employee> readEmployees() {

		List<Employee> employees = new ArrayList<Employee>();
		Reader fr = null;
		BufferedReader br = null;
		try {
			File inFile = new File("R://JAVA_SW_12_18//JAVA_Project//EmployeeCSV//EmployeeDetails1.csv");
			try {
				fr = new FileReader(inFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			br = new BufferedReader(fr);
			String line = null;
			int start = 0;
			while (true) {
				try {
					line = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (line == null || line.equals("")) {
					break;
				}
				if (start != 0) {
					Employee emp = builtEmployeeObject(line);
					employees.add(emp);
				}

				start++;
			}
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return employees;
	}

	public static Employee builtEmployeeObject(String line) {
		String[] employeeParameters = line.split(",");
		Employee emp = new Employee();
		SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		emp.setEmployeeId(Integer.parseInt(employeeParameters[0]));
		emp.setEmpNo(Integer.parseInt(employeeParameters[1]));
		emp.setName(employeeParameters[2]);
		emp.setSalary(Float.parseFloat(employeeParameters[3]));
		try {
			emp.setDoj(formatter.parse(employeeParameters[4]));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		emp.setAge(Integer.parseInt(employeeParameters[5]));
		return emp;
	}

}