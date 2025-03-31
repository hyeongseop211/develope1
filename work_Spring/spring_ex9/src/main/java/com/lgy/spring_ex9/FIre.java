package com.lgy.spring_ex9;

public class FIre {
	private String name;
	private String skill;
	private int Rank;
	
	
	public void getFIreInfo() {
		System.out.println("이름 :"+getName());
		System.out.println("기술 :"+getSkill());
		System.out.println("티어 :"+getRank());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getRank() {
		return Rank;
	}
	public void setRank(int rank) {
		Rank = rank;
	}
	
	
}
