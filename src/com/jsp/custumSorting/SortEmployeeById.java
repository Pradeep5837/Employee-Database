 package com.jsp.custumSorting;

import java.util.Comparator;

import com.jsp.edbms.Employee;

public class SortEmployeeById implements Comparator<Employee> {

	@Override
	public int compare(Employee x, Employee y) {
		String e1=x.getEmp_id(); //x is object to be insert y is already existing object
		String e2=y.getEmp_id();
		
		return e1.compareTo(e2);
	}

}
