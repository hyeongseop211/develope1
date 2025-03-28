package com.lgy.spring_ex6;

import java.util.ArrayList;

public class Employee {
	private String name;
	private int sal;
	private ArrayList<String> ja;
	
	
	
	public Employee(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public ArrayList<String> getJa() {
		return ja;
	}
	public void setJa(ArrayList<String> ja) {
		this.ja = ja;
	}
	
	
}
