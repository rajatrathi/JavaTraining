package com.Train1;

import java.io.FileWriter;
import java.io.IOException;

public class CSVListWriter {
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	private static final String FILE_HEADER = "EmpID,EmpNo,EmpName,EmpSalary,EmpDoj,EmpAge";

	public static void writeEmployees(CollectionEmployeeOperations impl) {

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("R://JAVA_SW_12_18//JAVA_Project//EmployeeCSV//EmployeeDetails1.csv");

			fileWriter.append(FILE_HEADER.toString());
			fileWriter.append(NEW_LINE_SEPARATOR);
			for (Employee employee : impl.empArray) {
				if (employee != null) {
					fileWriter.append(String.valueOf(employee.getEmployeeId()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(employee.getEmpNo()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(employee.getName());
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(employee.getSalary()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(employee.getDoj()));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(String.valueOf(employee.getAge()));
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
			}

			System.out.println("CSV file was created successfully !!!");
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}

		}

	}
}
