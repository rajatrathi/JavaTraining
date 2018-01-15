package com.Train1.EmployeeApplication;
import java.util.Scanner;

import com.Train1.Choices;
import com.Train1.CollectionEmployeeOperations;
import com.Train1.IEmployeeArrayOpertions;
import static com.Train1.CollectionEmployeeOperationsUtil.*;

public class CollectionEmployeeOperationsMainApp 

{
public static void main (String[] args) {
	IEmployeeArrayOpertions empCollectionImpl = new CollectionEmployeeOperations();
	populateDatafromExcel(empCollectionImpl);
	do {
		menu();
		Scanner sc1 = new Scanner(System.in);
    	int choices = sc1.nextInt();
    	Choices userChoice = Choices.getChoice(choices);
    	switch (userChoice) {
		case DISPLAY:
            ((CollectionEmployeeOperations) empCollectionImpl).display();
			break;
		case INSERT:
			insertEmployee(empCollectionImpl);
			break;
		case FINDEMPBYID:
			System.out.println("Enter Id of user which you want to search:");
			Scanner sc12 = new Scanner(System.in);
			int id = sc12.nextInt();
			findEmployeebyID(empCollectionImpl, id);
			break;
		case FINDEMPBYNAME:
			System.out.println("Enter Name of user which you want to search:");
			Scanner sc13 = new Scanner(System.in);
			String name = sc13.next();
			findEmployeebyName(empCollectionImpl, name);
			break;
		case DELETEEMPBYID:
			System.out.println("Enter Id of user which you want to delete:");
			Scanner sc11 = new Scanner(System.in);
			int id2 = sc11.nextInt();
			deleteEmployee(empCollectionImpl, id2);
			break;
		case UPDATE:
			System.out.println("Enter Id of user which you want to update:");
			updateEmployee(empCollectionImpl);
//			((CollectionEmployeeOperations) empCollectionImpl).display();
			break;
		case GROSSSALARYBYEMPID:
			System.out.println("Enter Id of employee whose gross salary you want to calculate:");
			Scanner sc14 = new Scanner(System.in);
			int id1 = sc14.nextInt();
			calculateGrossSalary(empCollectionImpl, id1);
			break;
		case SORTBYAGESALARY:
			System.out.println("Sort employee list based on their age-salary");
			sortbyAgeSalary((CollectionEmployeeOperations)empCollectionImpl);
			break;
		case SORTBYNAME:
			System.out.println("Sort employee list based on their names");
			sortByName((CollectionEmployeeOperations)empCollectionImpl);
			break;
		case UNIQUENAMES:
			System.out.println("Employee list based on unique names are");
			uniqueNames((CollectionEmployeeOperations)empCollectionImpl);
			break;
		case AGERANGE:
			System.out.println("Employee's based on their age range: ");
        	ageRange((CollectionEmployeeOperations)empCollectionImpl);
			break;
		case EXIT:
			populateDatatoExcel((CollectionEmployeeOperations)empCollectionImpl);
			System.exit(0);
			break;
		}
	} while (true);
}
	
}
