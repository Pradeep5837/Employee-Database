package com.jsp.edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.jsp.custumException.EmployeeNotFoundException;
import com.jsp.custumSorting.SortEmployeeByAge;
import com.jsp.custumSorting.SortEmployeeById;
import com.jsp.custumSorting.SortEmployeeByName;
import com.jsp.custumSorting.SortEmployeeBySalary;
import com.jsp.custumException.*;



public class EmployeeManagemebtSystemImplemetation implements EmployeeManagementSystem {
	Scanner ip=new Scanner(System.in);
	Map<String, Employee> db=new LinkedHashMap<String,Employee>();
	@Override
	public void addEmployee() {System.out.println("enter the name");
	String name = ip.next();

	System.out.println("enter the age");
	int age = ip.nextInt();
	System.out.println("enter the salary");
	double salary = ip.nextDouble();
	Employee emp = new Employee(name,age, salary);
	db.put(emp.getEmp_id(), emp);
	System.out.println("Employee Record Inserted Successfully");
	System.out.println("Employee Id is " + emp.getEmp_id());

		
	}

	@Override
	public void displayEmployee() {System.out.println("enter the Id");
	String id = ip.next().toUpperCase();
	if (db.containsKey(id)) {
		Employee s = db.get(id);
		System.out.println(
				"Name :" + s.getName() + " Id :" + s.getEmp_id() + " Age :" + s.getAge() + " Marks :" + s.getSalary());
	} else {
		try {
			String message = "Employee with the Id " + id + " is not Found!";
			throw new EmployeeNotFoundException(message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	}

	@Override
	public void displayAllEmployee() {
		if (db.size() != 0) {
		Set<String> key = db.keySet();
		for (String i : key) {

			System.out.println(db.get(i));
		}
	} else {
		try {

			throw new EmployeeNotFoundException("No employee found");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

		
	}

	@Override
	public void removeEmployee() {
		System.out.println("Enter the id");
		String id = ip.next();
		id = id.toUpperCase();
		if (db.containsKey(id)) {
			db.remove(id);
			System.out.println("Employee removed ");
		} else {
			try {
				String message = "Employee with the Id " + id + " is not Found!";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void removeAllEmployee() {
		if (db.size() != 0) {
			System.out.println("employee Records Available:" + db.size());
			db.clear();
			System.out.println("All Employee Records Deleted Successfully!!");
			System.out.println("Employee Records Available: " + db.size());
		} else {
			try {
				String message = "Employee data base is empty";
				throw new EmployeeNotFoundException(message);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void updateEmployee() {
		System.out.println("enter the employee id");
		String id = ip.next().toUpperCase();
		if (db.containsKey(id)) {
			Employee s = db.get(id);
			System.out.println("1 :Update age\n2 :update name\n3 :update salary");
			switch (ip.nextInt()) {
			case 1:
				System.out.println("enter the age");
				int age = ip.nextInt();
				s.setAge(age);
				break;

			case 2:
				System.out.println("enter the name");
				s.setName(ip.next());
				break;

			case 3:
				System.out.println("enter the salary");
				s.setSalary(ip.nextDouble());
				break;

			default:
				try {
					throw new InvalidChoiceException("Invalid choice");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		} else {
			try {
				throw new EmployeeNotFoundException("No data is present");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	private static void display(List<Employee> list) {
		for (Employee s : list) {
			System.out.println(s);
		}
	}
	@Override
	public void countEmployee() {
		System.out.println("Number of Student records :" + db.size());

	}

	@Override
	public void sortEmployee() {
		if (db.size() >= 2) {
			Set<String> key = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for (String i : key) {
				list.add(db.get(i));
			}
			System.out.println("1: Sort By Id\n2 :Sort by Name\n3: Sort by Age\n4 :Sort by salary");
			System.out.println("Enter choice");
			switch (ip.nextInt()) {
			case 1:
				Collections.sort(list, new SortEmployeeById());
				display(list);
				break;

			case 2:
				Collections.sort(list, new SortEmployeeByName());
				display(list);
				break;

			case 3:
				Collections.sort(list, new SortEmployeeByAge());
				display(list);
				break;

			case 4:
				Collections.sort(list, new SortEmployeeBySalary());
				display(list);
				break;

			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}

		} else {
			try {
				throw new EmployeeNotFoundException("No sufficient employee object to sort");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void getEmployeeWithLowestSalary() {
		if (db.size() >= 2) {
			Set<String> key = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for (String i : key) {
				list.add(db.get(i));
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(0));
		} else {
			try {
				throw new EmployeeNotFoundException("No sufficient epmloyee objects to compare");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void getEmployeeWithHighestSalary() {
		if (db.size() >= 2) {
			Set<String> key = db.keySet();
			List<Employee> list = new ArrayList<Employee>();
			for (String i : key) {
				list.add(db.get(i));
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(db.size()-1));
		} else {
			try {
				throw new EmployeeNotFoundException("No sufficient employee objects to compare");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
