package com.lgy.Spring_ex2_1;

public class Rectangle {
	private int garo;
	private int sero;
	public int getGaro() {
		return garo;
	}
	public void setGaro(int garo) {
		this.garo = garo;
	}
	public int getSero() {
		return sero;
	}
	public void setSero(int sero) {
		this.sero = sero;
	}
	public void rs() {
		System.out.println("rs");
		System.out.println(garo+"*"+sero+"="+(garo*sero));
	}
}
