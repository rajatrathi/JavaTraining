package com.genricEmp;

import java.sql.SQLException;
import java.util.Scanner;
import static com.genricEmp.WildcardGenericEmployeeServiceUtil.*;

public class WildCardGenericEmployeeServiceMain {
	public static void main(String[] args) throws SQLException {
		IWildcardGenericEmployeeService<Employee> wildgenericEmp = new WildcardGenericEmployeeServiceImpl<>();
		do {
			menu();
			Scanner sc1 = new Scanner(System.in);
			int choices = sc1.nextInt();
			Choices userChoice = Choices.getChoice(choices);
			switch (userChoice) {
			case DISPLAY:
				((GenericEmployeeServiceImpl) wildgenericEmp).display();
				break;
			case INSERT:
				insertEmployee(wildgenericEmp);
				break;
			case FINDEMP:
				findEmployee(wildgenericEmp);
				break;
			case DELETE:
				deleteEmployee(wildgenericEmp);
				break;
			case UPDATE:
				updateEmployee(wildgenericEmp);
				break;
			case EXIT:
				System.exit(0);
				break;
			}
		} while (true);
	}
}