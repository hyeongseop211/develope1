package com.lgy.spring_ex6_2;

import java.util.ArrayList;

public class Professor {
	private String name;
	private int age;
	private ArrayList<String> subject;
	
	public Professor(String name) {
		this.name = name;
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
	public ArrayList<String> getSubject() {
		return subject;
	}
	public void setSubject(ArrayList<String> subject) {
		this.subject = subject;
	}
	
	
}
