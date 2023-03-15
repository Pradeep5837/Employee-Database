package com.jsp.custumSorting;

import java.util.Comparator;

import com.jsp.edbms.Employee;

public class SortEmployeeBySalary implements Comparator<Employee>{

	public int compare(Employee e1,Employee e2) {
		Double x=e1.getSalary();  //double is unboxing to Double
		Double y=e2.getSalary();
		return x.compareTo(y);
	}
}
