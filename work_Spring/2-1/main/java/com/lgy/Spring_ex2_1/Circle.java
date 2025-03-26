package com.lgy.Spring_ex2_1;

public class Circle {
	private double ban;
	public double getBan() {
		return ban;
	}

	public void setBan(double ban) {
		this.ban = ban;
	}
	
	public void result() {
		System.out.println("result");
		System.out.println("3.14 * "+ban+"*"+ban+"="+(3.14*ban*ban));
	}
}
