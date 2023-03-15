package com.jsp.edbms;

import java.util.Scanner;
import com.jsp.custumException.*;

public class Solution {

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		EmployeeManagementSystem emp = new EmployeeManagemebtSystemImplemetation();

		while (true) {

			System.out.println(
					"1 :Add Employee\n2 :Display Employee\n3 :Display All Employee\n4 :Remove Employee\n5 :Remove All Employee");
			System.out.println(
					"6 :Update Employee\n7 :Count Employee\n8 :Sort Employee\n9 :Get Employee With Lowest Salary\n10 :Get Employee With Highest Salary\n11 :Exit");
			System.out.println("Enter choice");
			switch (ip.nextInt()) {
			
			case 1:emp.addEmployee();
			break;

			case 2:emp.displayEmployee();
			break;

			case 3:emp.displayAllEmployee();
			break;

			case 4:emp.removeEmployee();;
			break;

			case 5:emp.removeAllEmployee();
			break;

			case 6:emp.updateEmployee();
			break;

			case 7:emp.countEmployee();
			break;

			case 8:emp.sortEmployee();
			break;

			case 9:emp.getEmployeeWithLowestSalary();
			break;

			case 10:emp.getEmployeeWithHighestSalary();
			break;

			case 11:System.out.println("Thank you");
			System.exit(0);
			break;

			default :try {
				throw new InvalidChoiceException("Invalid Choice");
			}catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
			}

		}
	}

}
