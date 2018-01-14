package com.genricEmp;

import java.sql.SQLException;
import java.util.Scanner;
import static com.genricEmp.GenericEmployeeServiceUtil.*;

public class GenericEmployeeServiceMain {
	public static void main(String[] args) throws SQLException {
		IGenericEmployeeService<Employee> genericEmp = new GenericEmployeeServiceImpl<Employee>();
		do {
			menu();
			Scanner sc1 = new Scanner(System.in);
			int choices = sc1.nextInt();
			Choices userChoice = Choices.getChoice(choices);
			switch (userChoice) {
			case DISPLAY:
				((GenericEmployeeServiceImpl) genericEmp).display();
				break;
			case INSERT:
				insertEmployee(genericEmp);
				break;
			case FINDEMP:
				findEmployee(genericEmp);
				break;
			case DELETE:
				deleteEmployee(genericEmp);
				break;
			case UPDATE:
				updateEmployee(genericEmp);
				break;
			case EXIT:
				System.exit(0);
				break;
			}
		} while (true);
	}
}