package com.jsp.custumSorting;

import java.util.Comparator;

import com.jsp.edbms.Employee;

public class SortEmployeeByName implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
