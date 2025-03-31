package com.lgy.spring_ex9;

public class water {
	private String name;
	private int rank;
	
	public void getwaterInfo() {
		System.out.println("이름 :"+getName());
		System.out.println("티어 :"+getRank());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
