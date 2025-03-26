package com.lgy.Spring_ex2_5;

public class MultipleTriangle {
	public static void main(String[] args) {
		Multiple mul = new Multiple();
		mul.setNum(240);
		mul.process();
		
		Triangle tri = new Triangle();
		tri.setNum1(4);
		tri.setNum2(3);
		tri.setNum3(5);
		tri.process();
	}
}
