package com.train;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.Date;
import java.util.List;



public class FileLoadingService {
	private static final int SIZEOFBATCH = 4;
	public  static void loadtoDatabase(String fileName) throws FileNotFoundException, Exception {
		System.out.println("Started loading file... " + fileName);
		try {
			
			Connection con;
			List<Employee> employees = CSVListReader.readEmployees(fileName);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementdb", "root", "rajatmysql1090");
			String insertQuery = "INSERT INTO EMPLOYEE (EmpID, EmpNo, EmpName, EmpSalary, EmpDoj, EmpAge)"+ "VALUES(?, ?, ?, ?, ?, ?)";				
			PreparedStatement ps = con.prepareStatement(insertQuery);
			try {
				con.setAutoCommit(false);
				int count = 1;
				boolean recordsstillPresent = true;
				for (Employee employee : employees) {
					if (employee == null) break;
					ps.setInt( 1, employee.getEmployeeId());
					ps.setInt( 2, employee.getEmpNo());
					ps.setString( 3, employee.getName());
					ps.setFloat( 4, employee.getSalary());
					Date JoinDate = employee.getDoj();
					java.sql.Date sqlEmpDoj = new java.sql.Date(JoinDate.getTime());
					ps.setDate( 5, sqlEmpDoj);
					ps.setInt( 6, employee.getAge());
					ps.addBatch();
					if (count++ % SIZEOFBATCH == 0) {
						int[] currentCount = ps.executeBatch();
						recordsstillPresent = false;
					} else {
						recordsstillPresent = true;
					}
				}
				
				if(recordsstillPresent) {
					int[] currentCount = ps.executeBatch();
				}
				
				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
				con.rollback();
			}
			Thread.sleep(5 * 1000); 	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed loading file... " + fileName);
	}

}
