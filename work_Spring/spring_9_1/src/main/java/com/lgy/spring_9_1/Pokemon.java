package com.lgy.spring_9_1;

public class Pokemon {
	private String name;
	private int tier;
	private String skill;
	
	public void getPokemonInfo() {
		System.out.println("이름 :"+getName());
		System.out.println("티어 :"+getTier());
		System.out.println("기술 :"+getSkill());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
}
