package com.jsp.edbms;

public class Employee {
	private String emp_id;
	private String name;
	private int age;
	private double salary;
	private static int count;
	public Employee( String name, int age, double salary) {
		
		this.emp_id = "JSP"+count;
		this.name = name;
		this.age = age;
		this.salary = salary;
		count++;
	}
	public String getEmp_id() {
		return emp_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Employee.count = count;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	

}
